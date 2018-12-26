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

