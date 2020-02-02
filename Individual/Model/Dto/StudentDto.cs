using System;

namespace Individual.Model.Dto
{
	public class StudentDto
	{
		public Guid StudentCode { get; set; }
		
		public string FirstName { get; set; }

		public string SecondName { get; set; }

		public string LastName { get; set; }
		
		public int Age { get; set; }
		
		public DateTime BirthDate { get; set; }
		
		public User User { get; set; }
		
		public Group Group { get; set; }
	}
}