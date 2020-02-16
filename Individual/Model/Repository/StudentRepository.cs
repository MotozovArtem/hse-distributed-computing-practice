using System;
using System.Collections.Generic;
using System.Text;

namespace Individual.Model.Repository
{
	class StudentRepository : IRepository<Student, int>
	{
		public Student Create(Student model)
		{
			throw new NotImplementedException();
		}

		public bool Delete(Student model)
		{
			throw new NotImplementedException();
		}

		public bool DeleteById(int id)
		{
			throw new NotImplementedException();
		}

		public IEnumerable<Student> FindAll()
		{
			throw new NotImplementedException();
		}

		public Student FindById(int id)
		{
			throw new NotImplementedException();
		}

		public Student Update(Student model)
		{
			throw new NotImplementedException();
		}

		public Student UpdateByIdAsync(int id, Student model)
		{
			throw new NotImplementedException();
		}
	}
}
