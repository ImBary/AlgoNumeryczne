import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
from datetime import datetime

obowd_data = pd.read_csv('/home/bary/AlgoNumeryczne/Zadanie1/Grafy/obwod.csv',delimiter=';')






# Convert 'X' and 'Y' columns to numeric type
obowd_data['X'] = pd.to_numeric(obowd_data['X'])
obowd_data['Y'] = pd.to_numeric(obowd_data['Y'])
# Plot the data with logarithmic scale
plt.plot(obowd_data['X'], obowd_data['Y'])
plt.xscale('log')

plt.yscale('log')
plt.xlabel('X')

plt.ylabel('Y')
plt.title('Your Logarithmic Plot Title')
plt.show()
