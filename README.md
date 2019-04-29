# UnitsConversionPuzzle
The problem solves a puzzle to generate a relationship between different user defined units. The problem statement, expected input, output are as described below.


The use of units is ubiquitous in science. Physics uses units to distinguish distance (e.g., meters, kilometers, etc.), weight (e.g., kilograms, grams), and many other quantities. Computer scientists have specialized units to describe storage capacity (e.g., kilobytes, megabytes, etc.). You are to write a program to display the conversion factors for a set of units.

Specifying the relationship between various units can be done in many different, but equivalent, ways. For example, the units for metric distance can be specified as the group of relationships between pairs for units: 1 km = 1000 m, 1 m = 100 cm, and 1 cm = 10 mm. An alternative set of pairs consists of: 1 km = 100000 cm, 1 km = 1000000 mm, and 1 m = 1000 mm. In either presentation, the same relationship can be inferred: 1 km = 1000 m = 100000 cm = 1000000 mm.

For this problem, the units are to be sorted according to their descending size. For example, among the length units cm, km, m, mm, km is considered the biggest unit since 1 km corresponds to a length greater than 1 cm, 1 m, and 1 mm. The remaining units can be sorted similarly. For this set, the sorted order would be: km, m, cm, mm.

This problem is limited to unit-systems whose conversion factors are integer multiples. Thus, factors such as 1 inch = 2.54 cm are not considered. Further, the set of units and the provided conversions are given such that all units can be expressed in terms of all other units.

Input
The input consists of several problems. Each problem begins with the number of units, N. N is an integer in the interval [2,10]. The following line contains N unique case-sensitive units, each of which consists of at most 5 characters (using only a–z and A–Z). Following the set of units are N−1 unique lines, each specifying a relationship between two different units, with the format containing the following four space-separated pieces: name of the unit; an “=”; a positive integer multiplier larger than 1; and the name of a second unit that is smaller than the one to the left of the equal sign. Each of these lines establishes how many units are equivalent to the larger unit on the left. Each unit appears in the set of N−1 lines and is given in such a way to ensure the entire system is defined. The set of multiples yields conversion factors that do not exceed 231−1.

The sentinel value of N=0 indicates the end of the input.

Output
For each set of units, produce one line of output that contains the equivalent conversions. The conversions should be sorted left to right, with the largest unit appearing on the left. The conversion factors should be defined with respect to the leftmost unit (i.e., the largest unit) and should be separated by “ = ”.

Sample Input:
4
km m mm cm
km = 1000 m
m = 100 cm
cm = 10 mm
4
m mm cm km
km = 100000 cm
km = 1000000 mm
m = 1000 mm
6
MiB Mib KiB Kib B b
B = 8 b
MiB = 1024 KiB
KiB = 1024 B
Mib = 1048576 b
Mib = 1024 Kib
6
Kib B MiB Mib KiB b
B = 8 b
MiB = 1048576 B
MiB = 1024 KiB
MiB = 8192 Kib
MiB = 8 Mib
0

Sample Output:
1km = 1000m = 100000cm = 1000000mm
1km = 1000m = 100000cm = 1000000mm
1MiB = 8Mib = 1024KiB = 8192Kib = 1048576B = 8388608b
1MiB = 8Mib = 1024KiB = 8192Kib = 1048576B = 8388608b
