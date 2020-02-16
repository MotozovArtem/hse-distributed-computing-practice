using System;
using System.Collections.Generic;
using System.Text;

namespace Individual.Model.Repository
{
	class UserRepository : IRepository<User, int>
	{
		public User Create(User model)
		{
			throw new NotImplementedException();
		}

		public bool Delete(User model)
		{
			throw new NotImplementedException();
		}

		public bool DeleteById(int id)
		{
			throw new NotImplementedException();
		}

		public IEnumerable<User> FindAll()
		{
			throw new NotImplementedException();
		}

		public User FindById(int id)
		{
			throw new NotImplementedException();
		}

		public User Update(User model)
		{
			throw new NotImplementedException();
		}

		public User UpdateByIdAsync(int id, User model)
		{
			throw new NotImplementedException();
		}
	}
}
