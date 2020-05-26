counter = 0
cloud_1 = []
cloud_2 = []
cloud_3 = []


for i in range(4):
    counter += 8
    print(str(counter) + " 3")
    cloud_1.append(str(counter) + " 3")

    counter += 11
    print(str(counter) + " 2")
    cloud_1.append(str(counter) + " 2")

    counter += 8
    print(str(counter) + " 3")
    cloud_3.append(str(counter) + " 3")

    counter += 9
    print(str(counter) + " 2")
    cloud_2.append(str(counter) + " 2")

    counter += 12

counter += 8
print(str(counter) + " 3")
cloud_1.append(str(counter) + " 3")


print("\n\nCLOUD_1")
for i in range(len(cloud_1)):
    print(cloud_1[i])

print("\n\nCLOUD_2")
for i in range(len(cloud_2)):
    print(cloud_2[i])

print("\n\nCLOUD_3")
for i in range(len(cloud_3)):
    print(cloud_3[i])
