using System;

namespace Individual.Model.Dto
{
	public class UserDto
	{
		public int Id { get; set; }
		
		public string Login { get; set; }
		
		public string Password { get; set; }
		
		public DateTime RegistrationDateTime { get; set; }
	}
}