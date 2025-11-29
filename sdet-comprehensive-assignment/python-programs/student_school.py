"""
Python OOPs - Student and School Management System
Demonstrates inheritance and method implementation
"""


class Student:
    """Base class representing a student with basic information"""
    
    def __init__(self, name, grade, age):
        """
        Initialize student with Name, Grade, and Age
        
        Args:
            name (str): Student's name
            grade (str): Student's grade/class
            age (int): Student's age
        """
        self.name = name
        self.grade = grade
        self.age = age
    
    def display(self):
        """Display student information"""
        print("\n--- Student Information ---")
        print(f"Name: {self.name}")
        print(f"Grade: {self.grade}")
        print(f"Age: {self.age}")


class School(Student):
    """
    School class inheriting from Student
    Adds school-specific information and methods
    """
    
    def __init__(self, name, grade, age, school_name, student_id):
        """
        Initialize School object with student details and school information
        
        Args:
            name (str): Student's name
            grade (str): Student's grade/class
            age (int): Student's age
            school_name (str): Name of the school
            student_id (str): Student's ID in the school
        """
        # Call parent class constructor
        super().__init__(name, grade, age)
        self.school_name = school_name
        self.student_id = student_id
    
    def SchoolStudentDisplay(self):
        """
        Display school student information
        Shows Name, Grade, Age along with school-specific details
        """
        print("\n=== School Student Information ===")
        print(f"Name: {self.name}")
        print(f"Grade: {self.grade}")
        print(f"Age: {self.age}")
        print(f"School: {self.school_name}")
        print(f"Student ID: {self.student_id}")


def main():
    """Main function to demonstrate Student and School classes"""
    print("=" * 50)
    print("Python OOPs - Student Management System")
    print("=" * 50)
    
    # Create Student object
    student1 = Student("Alice Johnson", "10th Grade", 15)
    student1.display()
    
    # Create another Student object
    student2 = Student("Bob Williams", "9th Grade", 14)
    student2.display()
    
    print("\n" + "=" * 50)
    print("School Class (Inheriting from Student)")
    print("=" * 50)
    
    # Create School object
    school_student1 = School(
        name="Charlie Brown",
        grade="11th Grade",
        age=16,
        school_name="Lincoln High School",
        student_id="LHS2024001"
    )
    school_student1.SchoolStudentDisplay()
    
    # Create another School object
    school_student2 = School(
        name="Diana Prince",
        grade="12th Grade",
        age=17,
        school_name="Washington Academy",
        student_id="WA2024025"
    )
    school_student2.SchoolStudentDisplay()
    
    print("\n" + "=" * 50)
    print("Demonstrating Inheritance")
    print("=" * 50)
    print(f"\nIs school_student1 an instance of School? {isinstance(school_student1, School)}")
    print(f"Is school_student1 an instance of Student? {isinstance(school_student1, Student)}")
    
    # School object can also use parent class method
    print("\n--- Using parent class display() method ---")
    school_student1.display()
    
    print("\n" + "=" * 50)
    print("Demo completed successfully!")
    print("=" * 50)


if __name__ == "__main__":
    main()
