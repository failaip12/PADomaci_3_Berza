import pandas as pd
import numpy as np
import random
import time

# Load CSV data into a DataFrame
df = pd.read_csv('C:/Users/jhjkh/Downloads/nasdaq_screener_1704484161416.csv')

df = df.replace([np.inf, -np.inf], np.nan).dropna(subset=['Market Cap'])

# Sort DataFrame by Market Cap
df_sorted = df.sort_values(by='Market Cap', ascending=False)

a = 'static String[][] stockData = {'

# Check if there are any rows left after dropping NaN or infinite values
if df_sorted.empty:
    print("Error: No valid rows remaining after removing NaN or infinite values in 'Market Cap' column.")
else:
    # Calculate probabilities proportional to Market Cap
    total_market_cap = df_sorted['Market Cap'].sum()
    probabilities = df_sorted['Market Cap'] / total_market_cap

    # Check if there are any finite probabilities
    if probabilities.isnull().any():
        print("Error: Infinite or NaN values found in 'Market Cap' column.")
    else:
        # Select 25 random lines with probability proportional to Market Cap
        selected_rows = random.choices(df_sorted.index, weights=probabilities, k=40)

        # Display the selected rows
        for _, data in df_sorted.loc[selected_rows].iterrows():
            a += "{"
            a += f'"{data["Symbol"]}", "{data["Name"]}", "{data["Last Sale"]}", "{data["Net Change"]}", "{int(time.time())}"'
            a += "},\n"

a += "};"
print(a)
