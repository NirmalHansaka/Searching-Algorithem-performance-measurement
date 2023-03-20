import string
import random
from timeit import default_timer as time_counter

first_unsorted_list = [] * 1000
second_unsorted_list = [] * 10000
third_unsorted_list = [] * 100000

for i in range(0, 1000):
    first_unsorted_list.append(''.join(random.sample(string.ascii_lowercase, k=10)))

for i in range(0, 10000):
    second_unsorted_list.append(''.join(random.sample(string.ascii_lowercase, k=10)))

for i in range(0, 100000):
    third_unsorted_list.append(''.join(random.sample(string.ascii_lowercase, k=10)))


def liner_search(search_word, search_list, n):
    for i in range(0, n):
        if search_word == search_list[i]:
            print("Word Found")
            break




thousand_unsorted_list = first_unsorted_list
start_time = time_counter()
liner_search(thousand_unsorted_list[999], thousand_unsorted_list, 1000)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 1000 unsorted string data set : {round(execute_time, 7)} ms\n')

ten_thousand_unsorted_list = second_unsorted_list
start_time = time_counter()
liner_search(ten_thousand_unsorted_list[9999], ten_thousand_unsorted_list, 10000)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 10000 unsorted string data set : {round(execute_time, 7)} ms\n')

hundred_thousand_unsorted_list = third_unsorted_list
start_time = time_counter()
liner_search(hundred_thousand_unsorted_list[99999], hundred_thousand_unsorted_list, 100000)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 100000 unsorted string data set : {round(execute_time, 7)} ms\n')