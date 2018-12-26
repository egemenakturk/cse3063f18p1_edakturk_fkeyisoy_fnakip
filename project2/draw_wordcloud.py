from __future__ import division
from wordcloud import WordCloud
import matplotlib.pyplot as plt
from PIL import Image
import numpy as np


def draw_tf(tf_top_50):
    mask = np.array(Image.open('./masks/twitter_mask.png'))
    cloud = WordCloud(background_color='white', relative_scaling=0.7, width=1366, height=768, mask=mask).generate_from_frequencies(tf_top_50)
    plt.imshow(cloud)
    plt.axis('off')
    plt.savefig('./output/tf_wordcloud.pdf', format='pdf')

def draw_tfidf(tf_top_50):
    mask = np.array(Image.open('./masks/twitter_mask.png'))
    cloud = WordCloud(background_color='white', relative_scaling=0.7, width=1366, height=768, mask=mask).generate_from_frequencies(tf_top_50)
    plt.imshow(cloud)
    plt.axis('off')
    plt.savefig('./output/tfifd_wordcloud.pdf', format='pdf')