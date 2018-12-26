from cStringIO import StringIO
from pdfminer.pdfinterp import PDFResourceManager, PDFPageInterpreter
from pdfminer.converter import TextConverter
from pdfminer.layout import LAParams
from pdfminer.pdfpage import PDFPage
import os
import word_counter
import sys, getopt


def convert(fname, pages=None):
    if not pages:
        pagenums = set()
    else:
        pagenums = set(pages)

    output = StringIO()
    manager = PDFResourceManager()
    converter = TextConverter(manager, output, laparams=LAParams())
    interpreter = PDFPageInterpreter(manager, converter)

    infile = file(fname, 'rb')
    for page in PDFPage.get_pages(infile, pagenums):
        interpreter.process_page(page)
    infile.close()
    converter.close()
    text = output.getvalue()
    output.close
    return text


def convert_multiple(pdf_dir, txt_dir):
    if pdf_dir == "": pdf_dir = os.getcwd() + "\\"  # if no pdfDir passed in
    for pdf in os.listdir(pdf_dir):  # iterate through pdfs in pdf directory
        file_extension = pdf.split(".")[-1]
        if file_extension == "pdf":
            pdf_filename = pdf_dir + pdf
            text = convert(pdf_filename)  # get string of text content of pdf
            text = text.lower()
            for char in '-.,"/1234567890(){}[]&%+^!#$':
                text = text.replace(char, ' ')
            text_filename = txt_dir + pdf + ".txt"
            text_file = open(text_filename, "w")  # make text file
            text_file.write(text)  # write text to text file
