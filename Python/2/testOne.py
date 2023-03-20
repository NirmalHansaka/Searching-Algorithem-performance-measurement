import math
import random

li = range(0, 1000000)

thousand_unsorted_list = random.sample(li, 1000)
ten_thousand_unsorted_list = random.sample(li, 10000)
hundred_thousand_unsorted_list = random.sample(li, 100000)
print(thousand_unsorted_list)

thousand_sorted_list = thousand_unsorted_list.sort()
# ten_thousand_unsorted_list = ten_thousand_unsorted_list.sort()
# hundred_thousand_unsorted_list = hundred_thousand_unsorted_list.sort()

# print(thousand_unsorted_list)

# def liner_search (search_number, search_list):
#     for i in range(0, 1000):
#         if search_number == search_list[i]:
#             print(search_number, i)
#             break
#
#         elif i == len(search_list)-1:
#             print('Number not found')


# liner_search(2153, thousand_unsorted_list)

# def binary_search(search_number, search_list):
#
#     left_position = 0
#     right_position = len(search_list) - 1
#     custom_value = 0
#
#     while left_position <= right_position:
#         middle_position = (left_position + right_position) // 2
#         print(left_position,  right_position, middle_position)
#         if search_number == search_list[middle_position]:
#             print("number found");
#             custom_value = 1
#             break
#
#         elif search_number > search_list[middle_position]:
#             left_position = middle_position + 1
#
#         elif search_number < search_list[middle_position]:
#             right_position = middle_position-1
#
#     if custom_value == 0:
#         print('number not found')
#
# binary_search (thousand_unsorted_list[10], thousand_unsorted_list)

def binary_search (search_list, search_number, left_position, right_position):

    if right_position >= 1:
        middle_position = (left_position + right_position) // 2

        if search_number == search_list[middle_position]:
            print('number found')

        elif search_number > search_list[middle_position]:
            binary_search(search_list, search_number, middle_position+1, right_position)

        else:
            binary_search(search_list, search_number, left_position, middle_position-1)













def jump_search(search_number, search_list):

    jump_value = int(math.sqrt(len(search_list)-1))
    left_position = 0
    right_position = jump_value

    while search_list[jump_value] <= search_number and right_position < len(search_list):
        left_position = right_position
        right_position = right_position + jump_value

        if right_position > len(search_list)-1:
            right_position = len(search_list)-1

    for i in range(left_position, right_position):
        if search_number == search_number[i]:
            print('number found')
            break





def exponential_search (search_number, search_list):

    if search_list[0] == search_number:
        print('number found in first index')

    i = 1
    while i <= len(search_list)-1 and search_list[i] <= search_number:
        i = i * 2























