import random


def generate(employee_num, department_num):
    department = ['department' + str(i).zfill(5) for i in range(department_num)]
    manager = ['manager' + str(i).zfill(5) for i in range(department_num)]
    with open('dep_man.txt', 'w') as f:
        for i in range(department_num):
            f.write(department[i] + ',' + manager[i] + '\n')

    with open('emp_dep.txt', 'w') as f:
        for i in range(employee_num):
            f.write('employee' + str(i).zfill(5) + ',' + random.choice(department) + '\n')


if __name__ == '__main__':
    generate(1000000, 1000)
