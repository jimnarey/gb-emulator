#!/usr/bin/python3

file_object = open('../other/switch_text.txt', 'w')
section = ""

for i in range(256):

    section = section + 'case ' + hex(i) + ': \n\n' + '\tbreak;' + '\n\n'


file_object.write(section)
file_object.close()
