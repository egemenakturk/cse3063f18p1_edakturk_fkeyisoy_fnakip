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



#os.remove("./txt_formats/filtered_text.txt")

