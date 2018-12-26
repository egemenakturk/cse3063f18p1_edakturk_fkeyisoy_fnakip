import PDFtoTXTConvert
import word_counter
import os

d = {}
word_freq = []
tf_idf_freq = []

pdf_dir = "./articles/"
txt_dir = "./txt_formats/"

PDFtoTXTConvert.convert_multiple(pdf_dir, txt_dir)
word_counter.get_rid_of_stopword(txt_dir)
word_counter.count_words(word_freq, d)
word_counter.tf_idf_cal(d,txt_dir,tf_idf_freq)

if txt_dir == "": txt_dir = os.getcwd() + "\\"  # if no txt_dir passed in
for txt in os.listdir(txt_dir):
    file_extension = txt.split(".")[-1]
    if file_extension == "txt":
        txt_filename = txt_dir + txt
        os.remove(txt_filename)


txt_dir = "./filtered_txt/"
if txt_dir == "": txt_dir = os.getcwd() + "\\"  # if no txt_dir passed in
for txt in os.listdir(txt_dir):
    file_extension = txt.split(".")[-1]
    if file_extension == "txt":
        txt_filename = txt_dir + txt
        os.remove(txt_filename)

