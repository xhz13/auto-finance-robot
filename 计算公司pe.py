import tushare as ts

# 设置tushare pro的token并初始化接口
ts.set_token('your token here')  # 请替换为你的tushare pro的token
pro = ts.pro_api()

# 获取所有A股的基本信息
df = pro.stock_basic(exchange='', list_status='L')

# 计算PE
df['pe'] = df['close'] / df['eps']

# 打印结果
print(df)