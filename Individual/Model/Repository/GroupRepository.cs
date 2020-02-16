using System;
using System.Collections.Generic;
using System.Text;

namespace Individual.Model.Repository
{
	class GroupRepository : IRepository<Group, int>
	{
		public Group Create(Group model)
		{
			throw new NotImplementedException();
		}

		public bool Delete(Group model)
		{
			throw new NotImplementedException();
		}

		public bool DeleteById(int id)
		{
			throw new NotImplementedException();
		}

		public IEnumerable<Group> FindAll()
		{
			throw new NotImplementedException();
		}

		public Group FindById(int id)
		{
			throw new NotImplementedException();
		}

		public Group Update(Group model)
		{
			throw new NotImplementedException();
		}

		public Group UpdateByIdAsync(int id, Group model)
		{
			throw new NotImplementedException();
		}
	}
}
