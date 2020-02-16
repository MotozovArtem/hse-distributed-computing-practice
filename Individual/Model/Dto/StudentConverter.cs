using System;
using System.Collections.Generic;
using System.Text;

namespace Individual.Model.Dto
{
	class StudentConverter : IConverter<Student, StudentDto>
	{
		public Student ToDomain(StudentDto dto)
		{
			throw new NotImplementedException();
		}

		public StudentDto ToDto(Student obj)
		{
			throw new NotImplementedException();
		}
	}
}
