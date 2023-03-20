import math
import random
from timeit import default_timer as time_counter

li_one = range(0, 1000000)
thousand_unsorted_list = random.sample(li_one, 1000)

li_two = range(0, 1000000)
ten_thousand_unsorted_list = random.sample(li_two, 10000)

li_three = range(0, 1000000)
hundred_thousand_unsorted_list = random.sample(li_three, 100000)


def liner_search(search_number, search_list, n):
    for i in range(0, n):
        if search_number == search_list[i]:
            print(search_number, i)
            break




unsorted_list_one = thousand_unsorted_list
start_time = time_counter()
liner_search(unsorted_list_one[999], unsorted_list_one, 1000)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 1000 unsorted integer data set : {round(execute_time, 7)} ms\n')

unsorted_list_two = ten_thousand_unsorted_list
start_time = time_counter()
liner_search(unsorted_list_two[9999], unsorted_list_two, 10000)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 10000 unsorted data set : {round(execute_time, 7)} ms\n')

unsorted_list_three = hundred_thousand_unsorted_list
start_time = time_counter()
liner_search(unsorted_list_three[99999], unsorted_list_three, 100000)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 100000 unsorted data set : {round(execute_time, 7)} ms\n')


