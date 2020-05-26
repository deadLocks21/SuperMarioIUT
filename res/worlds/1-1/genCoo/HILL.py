c1 = 0
c2 = 16

hill_1 = []
hill_2 = []

for i in range(5):
    hill_1.append(str(str(c1) + " 11"))
    hill_2.append(str(str(c2) + " 9"))
    c1 += 48
    c2 += 48

for i in range(len(hill_1)):
    print(hill_1[i])
print("HILL_1\n\n")

for i in range(len(hill_2)):
    print(hill_2[i])
print("HILL_2\n\n")
