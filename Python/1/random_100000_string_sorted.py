import math
import string
import random
from timeit import default_timer as time_counter

string_list = [] * 100000
for i in range(0, 100000):
    string_list.append(''.join(random.sample(string.ascii_lowercase, k=10)))

string_list.sort()


def liner_search(search_word, search_list):
    for i in range(0, 100000):
        if search_word == search_list[i]:
            print("Number Found")
            break


def binary_search(search_list, search_word, left_position, right_position):
    if right_position >= 1:
        middle_position = (left_position + right_position) // 2

        if search_word == search_list[middle_position]:
            print('Word found')

        elif search_word > search_list[middle_position]:
            binary_search(search_list, search_word, middle_position + 1, right_position)

        else:
            binary_search(search_list, search_word, left_position, middle_position - 1)


def jump_search(search_word, search_list):
    jump_value = int(math.sqrt(len(search_list) - 1))
    left_position = 0
    right_position = jump_value

    while search_list[right_position] <= search_word and right_position < len(search_list):
        left_position = right_position
        right_position = right_position + jump_value

        if right_position > len(search_list) - 1:
            right_position = len(search_list) - 1
            break

    for i in range(left_position, right_position + 1):
        if search_word == search_list[i]:
            print('Word found')
            break


def exponential_search(search_word, search_list):
    if search_list[0] == search_word:
        print('Word found in first index')

    i = 1
    while i <= len(search_list) - 1 and search_list[i] <= search_word:
        i = i * 2

    binary_search(search_list, search_word, i // 2, min(len(search_list) - 1, i))

start_time = time_counter()
liner_search(string_list[99999], string_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'liner search execution time for 1000 sorted string data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
binary_search(string_list, string_list[99999], 0, len(string_list)-1)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'binary search execution time for 100000 sorted string data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
jump_search(string_list[99999], string_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'jump search execution time for 100000 sorted string data set : {round(execute_time, 7)} ms\n')

start_time = time_counter()
exponential_search(string_list[99999], string_list)
end_time = time_counter()
execute_time = (end_time - start_time)*1000
print(f'exponential search execution time for 100000 sorted string data set : {round(execute_time, 7)} ms\n')