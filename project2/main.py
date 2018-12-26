import PDFtoTXTConvert
import word_counter
import os

d = {}
word_freq = []

pdf_dir = "./articles/"
txt_dir = "./articles/txt_formats/"

PDFtoTXTConvert.convert_multiple(pdf_dir, txt_dir)
word_counter.get_rid_of_stopword(txt_dir)
word_counter.count_words(word_freq, d)

os.remove("./articles/txt_formats/filtered_text.txt")
