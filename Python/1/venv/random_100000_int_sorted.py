import random
from timeit import default_timer as time_counter
import math


li = range(0, 100000)
integer_list = random.sample(li, 100000)
integer_list.sort()


def liner_search(search_number, search_list):
    for i in range(0, 100000):
        if search_number == search_list[i]:
            print("Number found")
            break




def binary_search(search_list, search_number, left_position, right_position):
    if right_position >= 1:
        middle_position = (left_position + right_position) // 2

        if search_list[middle_position] == search_number:
            print('number found')

        elif search_list[middle_position] < search_number:
            binary_search(search_list, search_number, middle_position + 1, right_position)

        else:
            binary_search(search_list, search_number, left_position, middle_position - 1)
    else:
        print("item not found")


def jump_search(search_number, search_list):
    jump_value = int(math.sqrt(len(search_list) - 1))
    left_position = 0
    right_position = jump_value

    while search_list[right_position] <= search_number and right_position < len(search_list):
        left_position = right_position
        right_position = right_position + jump_value

        if right_position > len(search_list) - 1:
            right_position = len(search_list) - 1
            break

    for i in range(left_position, right_position+1):
        if search_number == search_list[i]:
            print('item found')
            break


def exponential_search(search_number, search_list):
    if search_list[0] == search_number:
        print('item found in first index')

    i = 1
    while i <= len(search_list)-1 and search_list[i] <= search_number:
        i = i * 2

    binary_search(search_list, search_number, i//2, min(len(search_list)-1, i))


def interpolation_search(search_number, search_list):
    left_position = 0
    right_position = len(search_list)-1

    while left_position <= right_position:
        mid_position = left_position + (((search_number-search_list[left_position])*(right_position-left_position))//(search_list[right_position]-search_list[left_position]))
        if search_list[mid_position] == search_number:
            print("Number found")
            break
        elif search_list[mid_position] < search_number:
            left_position = mid_position + 1
        else:
            right_position = mid_position + 1


start_time = time_counter()
liner_search(integer_list[99999], integer_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 100000 sorted integer data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
binary_search(integer_list, integer_list[99999], 0, len(integer_list)-1)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'binary search execution time for 100000 sorted integer data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
jump_search(integer_list[99999], integer_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'jump search execution time for 100000 sorted integer data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
exponential_search(integer_list[99999], integer_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'exponential search execution time for 100000 sorted integer data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
interpolation_search(integer_list[99999], integer_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'interpolation search execution time for 100000 sorted integer data set : {round(execute_time, 7)} ms\n')
