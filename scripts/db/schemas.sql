Database changed
mysql> desc genres;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | smallint     | NO   | PRI | NULL    | auto_increment |
| type  | varchar(255) | NO   | UNI | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
2 rows in set (0.01 sec)

mysql> desc genre_user;
+----------+----------+------+-----+---------+-------+
| Field    | Type     | Null | Key | Default | Extra |
+----------+----------+------+-----+---------+-------+
| genre_id | smallint | NO   | PRI | NULL    |       |
| user_id  | bigint   | NO   | PRI | NULL    |       |
+----------+----------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> desc interest_user;
+-------------+--------+------+-----+---------+-------+
| Field       | Type   | Null | Key | Default | Extra |
+-------------+--------+------+-----+---------+-------+
| interest_id | bigint | NO   | PRI | NULL    |       |
| user_id     | bigint | NO   | PRI | NULL    |       |
+-------------+--------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> desc interests;
+-------+--------------+------+-----+---------+----------------+
| Field | Type         | Null | Key | Default | Extra          |
+-------+--------------+------+-----+---------+----------------+
| id    | bigint       | NO   | PRI | NULL    | auto_increment |
| name  | varchar(255) | NO   | UNI | NULL    |                |
+-------+--------------+------+-----+---------+----------------+
2 rows in set (0.00 sec)

mysql> desc matches;
+----------------+-------------+------+-----+---------+----------------+
| Field          | Type        | Null | Key | Default | Extra          |
+----------------+-------------+------+-----+---------+----------------+
| id             | bigint      | NO   | PRI | NULL    | auto_increment |
| timestamp      | datetime(6) | YES  |     | NULL    |                |
| user_id        | bigint      | YES  | MUL | NULL    |                |
| user_target_id | bigint      | YES  | MUL | NULL    |                |
+----------------+-------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)

mysql> desc preferences;
+----------+--------+------+-----+---------+-------+
| Field    | Type   | Null | Key | Default | Extra |
+----------+--------+------+-----+---------+-------+
| user_id  | bigint | NO   | PRI | NULL    |       |
| distance | bigint | NO   |     | NULL    |       |
| max_age  | int    | NO   |     | NULL    |       |
| min_age  | int    | NO   |     | NULL    |       |
+----------+--------+------+-----+---------+-------+
4 rows in set (0.01 sec)

mysql> desc roles;
+---------+----------------------------------+------+-----+---------+-------+
| Field   | Type                             | Null | Key | Default | Extra |
+---------+----------------------------------+------+-----+---------+-------+
| user_id | bigint                           | NO   | PRI | NULL    |       |
| type    | enum('ADMIN','MODERATOR','USER') | NO   |     | NULL    |       |
+---------+----------------------------------+------+-----+---------+-------+
2 rows in set (0.00 sec)

mysql> desc swipes;
+----------------+-------------+------+-----+---------+----------------+
| Field          | Type        | Null | Key | Default | Extra          |
+----------------+-------------+------+-----+---------+----------------+
| id             | bigint      | NO   | PRI | NULL    | auto_increment |
| timestamp      | datetime(6) | YES  |     | NULL    |                |
| type           | tinyint     | YES  |     | NULL    |                |
| user_id        | bigint      | YES  | MUL | NULL    |                |
| user_target_id | bigint      | YES  | MUL | NULL    |                |
+----------------+-------------+------+-----+---------+----------------+
5 rows in set (0.00 sec)

mysql> desc users;
+-------------------+----------------------------+------+-----+---------+----------------+
| Field             | Type                       | Null | Key | Default | Extra          |
+-------------------+----------------------------+------+-----+---------+----------------+
| id                | bigint                     | NO   | PRI | NULL    | auto_increment |
| account_type      | enum('PREMIUM','STANDARD') | NO   |     | NULL    |                |
| bio               | varchar(255)               | YES  |     | NULL    |                |
| birthday          | date                       | NO   |     | NULL    |                |
| email             | varchar(255)               | NO   | UNI | NULL    |                |
| name              | varchar(255)               | NO   |     | NULL    |                |
| password          | varchar(255)               | NO   |     | NULL    |                |
| registration_date | date                       | YES  |     | NULL    |                |
+-------------------+----------------------------+------+-----+---------+----------------+
8 rows in set (0.01 sec)

mysql> desc user_details;
+-------------+--------------------------------------+------+-----+---------+-------+
| Field       | Type                                 | Null | Key | Default | Extra |
+-------------+--------------------------------------+------+-----+---------+-------+
| user_id     | bigint                               | NO   | PRI | NULL    |       |
| last_online | datetime(6)                          | YES  |     | NULL    |       |
| status      | enum('INVISIBLE','OFFLINE','ONLINE') | NO   |     | NULL    |       |
+-------------+--------------------------------------+------+-----+---------+-------+
3 rows in set (0.00 sec)