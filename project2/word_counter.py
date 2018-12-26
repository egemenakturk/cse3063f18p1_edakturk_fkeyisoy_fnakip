from __future__ import division
import os
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import csv
import draw_wordcloud
import math


def get_rid_of_stopword(txt_dir):
    stpwrds = open("stopwords.txt")
    stpword = stpwrds.read()
    stop_words = stpword.split()
    if txt_dir == "": txt_dir = os.getcwd() + "\\"  # if no txt_dir passed in
    for txt in os.listdir(txt_dir):
        file_extension = txt.split(".")[-1]
        if file_extension == "txt":
            txt_filename = txt_dir + txt
            file = open(txt_filename)
            txt_file = file.read()
            for char in '-.,"`"/1234567890(){}[]&%+^!#$':
                text = txt_file.replace(char, ' ')
            text=txt_file.split()
            for word in text:
                if not word in stop_words:
                    if len(word) > 2 :
                        append_file = open("./filtered_txt/"+txt, 'a')
                        append_file.write("  "+word)
                        append_file.close()

def count_words(word_freq, d):
    txt_dir = "./filtered_txt/"
    if txt_dir == "": txt_dir = os.getcwd() + "\\"  # if no txt_dir passed in
    for txt in os.listdir(txt_dir):
        file_extension = txt.split(".")[-1]
        if file_extension == "txt":
            txt_filename = txt_dir + txt
            file = open(txt_filename)
            txt_file = file.read()
            word_list = txt_file.split()
            for word in word_list:
                if len(word) > 2:
                    d[word] = d.get(word, 0)+1
    tf_d_to_list_top_50(word_freq, d)


def tf_idf_cal(d,txt_dir, tf_idf_freq):
    if txt_dir == "": txt_dir = os.getcwd() + "\\"  # if no txt_dir passed in
    doc_count= len(os.listdir(txt_dir))

    tfidf_dict = {}
    for word in list(d.keys()):
        word_counter = 0
        # Checking how many documents include 'word'
        txt_dir = "./filtered_txt/"
        if txt_dir == "": txt_dir = os.getcwd() + "\\"  # if no txt_dir passed in
        for txt in os.listdir(txt_dir):
            file_extension = txt.split(".")[-1]
            if file_extension == "txt":
                txt_filename = txt_dir + txt
                file = open(txt_filename)
                txt_file = file.read()
                word_list = txt_file.split()
                for doc in word_list:
                    if word in doc:
                        word_counter += 1
        if word_counter > 0 and doc_count != 0 and len(word) > 2:
            doc_count_diveded_word_counter = doc_count / word_counter
            tfidf = d[word] * math.log(doc_count_diveded_word_counter)
            tfidf_dict[word] = tfidf
    tfidf_d_to_list_top_50(tf_idf_freq, tfidf_dict)



def tf_d_to_list_top_50(word_freq, d):
    for key, value in d.items():
        word_freq.append((value,key))

    word_freq.sort(reverse=True)
    counter = 0
    data = []
    while counter < 50:
        data.append([word_freq[counter][1], word_freq[counter][0]])
        counter = counter + 1
    write_to_csv_tf_list(data)
    tf_csv_reader()

def tfidf_d_to_list_top_50(word_freq, d):
    for key, value in d.items():
        word_freq.append((value,key))
    word_freq.sort(reverse=True)
    counter = 0
    data = []
    while counter < 50:
        data.append([word_freq[counter][1], word_freq[counter][0]])
        counter = counter + 1
    write_to_csv_tfidf_list(data)
    tfidf_csv_reader()

def write_to_csv_tfidf_list(data):
    csv.register_dialect(';dialect', delimiter=';', quoting=csv.QUOTE_NONE, skipinitialspace=True)
    with open('./output/tfidf_list.csv', 'wb') as f:
        writer = csv.writer(f, dialect=';dialect')
        for row in data:
            writer.writerow(row)
        f.close()

def write_to_csv_tf_list(data):
    csv.register_dialect(';dialect', delimiter=';', quoting=csv.QUOTE_NONE, skipinitialspace=True)
    with open('./output/tf_list.csv', 'wb') as f:
        writer = csv.writer(f, dialect=';dialect')
        for row in data:
            writer.writerow(row)
        f.close()


def tf_csv_reader():
    tf_top_50 = {}
    with open('./output/tf_list.csv', 'r') as wordcloud_file:
        reader = csv.reader(wordcloud_file, delimiter=';')
        for row in reader:
            tf_top_50[row[0]] = float(row[1])
        wordcloud_file.close()
    draw_wordcloud.draw_tf(tf_top_50)

def tfidf_csv_reader():
    tf_top_50 = {}
    with open('./output/tfidf_list.csv', 'r') as wordcloud_file:
        reader = csv.reader(wordcloud_file, delimiter=';')
        for row in reader:
            tf_top_50[row[0]] = float(row[1])
        wordcloud_file.close()
    draw_wordcloud.draw_tfidf(tf_top_50)

