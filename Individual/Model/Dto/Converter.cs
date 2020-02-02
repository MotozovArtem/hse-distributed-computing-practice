namespace IndividualSharp.Model.Dto
{
	public interface Converter<Domain, Dto> where Domain: DomainObject
	{
		Domain ToDomain(Dto dto);
		
		Dto ToDto(Domain obj);
	}
}