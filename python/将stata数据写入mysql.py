import pandas as pd
import stata_setup
import os
from sqlalchemy import create_engine

# stata的基础设置
stata_setup.config("D:\programs\stata","mp")

# 将Stata数据集转换为Pandas DataFrame
file_path = os.path.join('C:/Users/1/Desktop/Code/auto-finance-robot/数据文件', 'findata.dta')
df = pd.read_stata(file_path)
print(df)
# 连接到MySQL数据库 记得修改成自己的数据库信息
engine = create_engine('mysql+pymysql://root:12345@localhost/statadata')
conn = engine.connect()
# 给df添加一个主键
df.reset_index(inplace=True)
df.index = df.index + 1
df.rename(columns={'index': 'id'}, inplace=True)
# 将DataFrame保存到MySQL数据库中
df.to_sql(name='stock_data', con=conn, if_exists='replace', index=False)

# 关闭数据库连接
conn.close()
