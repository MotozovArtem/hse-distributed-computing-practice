using System;
using IndividualSharp.Utils;

namespace IndividualSharp.Model.Dto
{
	public class UserConverter: Converter<User, UserDto>
	{
		public User ToDomain(UserDto dto)
		{
			Preconditions.CheckNotNull(dto);
			User.Builder builder = new User.Builder();
			builder.SetId(dto.Id)
				.SetLogin(dto.Login)
				.SetPassword(dto.Password)
				.SetRegistrationDateTime(dto.RegistrationDateTime);
			return builder.Build();
		}

		public UserDto ToDto(User obj)
		{
			Preconditions.CheckNotNull(obj);
			return new UserDto()
			{
				Id = obj.Id,
				Login = obj.Login,
				Password = obj.Password,
				RegistrationDateTime = obj.RegistrationDateTime
			};
		}
	}
}