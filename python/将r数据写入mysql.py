import pandas as pd
from sqlalchemy import create_engine

# 读取CSV文件
data = pd.read_csv('C:/Users/1/Desktop/Code/auto-finance-robot/数据文件/企业的基本情况数据/基本信息/Info.csv', dtype={'stkcd': str})
data.drop_duplicates(subset='stkcd', keep='last',inplace=True)

# 创建数据库引擎
engine = create_engine('mysql+pymysql://root:12345@localhost/statadata')

# 将数据写入MySQL
data.to_sql('enterprise_classify', con=engine, index=False, if_exists='append')



