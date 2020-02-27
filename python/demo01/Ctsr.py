import csv, pymysql.cursors, datetime, time


def timer():
    start_time = time.perf_counter()
    sFileName = '测试表.csv'
    rFileName = 'SQL测试题1结果.csv'
    record_data = 0
    suc_data = 0
    ctsr_list = []
    with open(sFileName, newline='', encoding='UTF-8') as csvfile:
        rows = csv.reader(csvfile)
        for row in rows:
            record_data += 1
            ctsr_list.append(' '.join(row))

    ctsr_list = ctsr_list[1::]
    ctsr_listc = []

    for c in ctsr_list:
        ctsr_listc.append(c.split(' ', 4))

    # for n in range(0,10):
    #     print(ctsr_listc[n])
    # def conn_mysql():
    # Connect to the database
    connection = pymysql.connect(host='localhost',
                                 user='root',
                                 password='zw123',
                                 db='Subject',
                                 charset='utf8mb4',
                                 cursorclass=pymysql.cursors.DictCursor)

    try:
        with connection.cursor() as cursor:
            sql = '''
            create table Ctsr(
            id int primary key AUTO_INCREMENT,
            ceil_id int not null,
            tel_traffic float(8,4) not null,
            traffic float(9,4) not null,
            user_num int not null,
            date DATETIME not null
            )ENGINE=InnoDB  DEFAULT CHARSET=utf8; 
                    '''
            cursor.execute(sql)
            suc_data += 1

            for c in ctsr_listc:
                ceil_id, tel_traffic, traffic, user_num, date = int(c[0]), float(c[1]), float(c[2]), int(
                    c[3]), datetime.datetime.strptime(c[4], "%Y-%m-%d %H:%M:%S")
                # print(type(ceil_id), type(tel_traffic), type(traffic), type(user_num), type(date))
                # Create a new record
                sql = "INSERT INTO `Ctsr` (`ceil_id`, `tel_traffic`, `traffic` ,`user_num` ,`date`) VALUES ('%d', '%.4f', '%.4f', '%d', '%s')" % (
                    ceil_id, tel_traffic, traffic, user_num, date)
                # print(sql)
                cursor.execute(sql)
                suc_data += 1
            sql = [
                "ALTER TABLE Ctsr ADD Tbv FLOAT(10,4) NOT NULL",
                "ALTER TABLE Ctsr ADD Bvpu FLOAT(10,4) NOT NULL",
                "update Ctsr set Tbv=tel_traffic+traffic",
                "update Ctsr set Bvpu = (tel_traffic+traffic)/user_num WHERE user_num>0",
                "UPDATE Ctsr set date = DATE_ADD(date,interval 3 hour)"
            ]
            for n in range(5):
                # sql = input()
                cursor.execute(sql[n])
                suc_data += 1
            # connection is not autocommit by default. So you must commit to save
            # your changes.
        connection.commit()
        f = open(rFileName, 'w', encoding='utf-8')
        csv_writer = csv.writer(f,lineterminator='\r')
        csv_writer.writerow(['ceil_id', 'tel_traffic', 'traffic', 'user_num', 'date', 'Tbv', 'Bvpu'])
        with connection.cursor() as cursor:
            for c in range(len(ctsr_listc)):
                # Read a single record
                sql = "SELECT * FROM Ctsr WHERE id = %d" % int(c + 1)
                cursor.execute(sql)
                result = cursor.fetchone()
                result_list = list(result.values())
                csv_writer.writerow(result_list[1::])
        result = 0

    except:
        result = 1
    finally:
        connection.close()
    end_time = time.perf_counter()
    result_time = end_time - start_time
    result_list = [result, sFileName, rFileName, record_data, suc_data, result_time]
    return result_list


if __name__ == '__main__':
    print(timer())
