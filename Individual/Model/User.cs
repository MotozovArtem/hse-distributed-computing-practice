using System;
using Individual.Utils;

namespace Individual.Model
{
	public class User: DomainObject
	{
		public string Login { get; set; }
		
		public string Password { get; set; }
		
		public DateTime RegistrationDateTime { get; set; }

		public class Builder
		{
			private int _id;

			private string _login;

			private string _password;

			private DateTime _registrationDateTime;

			public Builder SetId(int id)
			{
				_id = id;
				return this;
			}
			
			public Builder SetLogin(string login)
			{
				Preconditions.CheckNotNull(login);
				_login = login;
				return this;
			}
			
			public Builder SetPassword(string password)
			{
				Preconditions.CheckNotNull(password);
				_password = password;
				return this;
			}
			
			public Builder SetRegistrationDateTime(DateTime registrationDateTime)
			{
				Preconditions.CheckNotNull(registrationDateTime);
				_registrationDateTime = registrationDateTime;
				return this;
			}

			public User Build()
			{
				var user = new User
				{
					Id = _id, 
					Login = _login,
					Password = _password,
					RegistrationDateTime = _registrationDateTime
				};
				return user;
			}	
		}
	}
}