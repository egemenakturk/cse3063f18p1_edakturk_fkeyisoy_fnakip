import os
import nltk
from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize
import csv
import draw_wordcloud


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
            text=txt_file.split()
            for word in text:
                if not word in stop_words:
                    append_file = open("./articles/txt_formats/filtered_text.txt",'a')
                    append_file.write("  "+word)
                    append_file.close()




def count_words(word_freq,d):
            file = open("./articles/txt_formats/filtered_text.txt")
            txt_file = file.read()
            word_list = txt_file.split()
            for word in word_list:
                if len(word) > 2:
                    d[word] = d.get(word, 0)+1
            tf_d_to_list_top_50(word_freq, d)


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


def write_to_csv_tf_list(data):
    csv.register_dialect(';dialect', delimiter=';', quoting=csv.QUOTE_NONE, skipinitialspace=True)
    with open('./output/tf_idf.csv', 'wb') as f:
        writer = csv.writer(f, dialect=';dialect')
        for row in data:
            writer.writerow(row)
        f.close()


def tf_csv_reader():
    tf_top_50 = {}
    with open('./output/tf_idf.csv', 'r') as wordcloud_file:
        reader = csv.reader(wordcloud_file, delimiter=';')
        for row in reader:
            tf_top_50[row[0]] = float(row[1])
        wordcloud_file.close()
    draw_wordcloud.draw_tf(tf_top_50)

