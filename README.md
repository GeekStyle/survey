# online demo
https://zuhlke.geekstylecn.com/swagger-ui.html#/order45controller

two apis, one is to upload a csv file and insert into database, another one is to query all the records in database

# what have I done?
## file upload
upload a csv file 

## convert csv file
convert a csv file using OpenCSV into a list then convert the list to List<Order>
  
## remove duplicates
first remove the duplicates inside the csv file, if the orderId or the customerId is the same, then remove the record
second, query if the database already inserted such duplicated data, if does contains, the remove it

## batch insert into database
using Mybatis to batch insert into MySQL

## return return
if validation failed, will return 400
if encounter server exception( for example, IOException ), then return 500 http code with an error message
if the data is valid, then return the 200 httpcode with how many data inserted and how many duplicates.

test
