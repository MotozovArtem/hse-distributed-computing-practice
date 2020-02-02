namespace Individual.Model.Dto
{
	public interface IConverter<TDomain, TDto> where TDomain: DomainObject
	{
		TDomain ToDomain(TDto dto);
		
		TDto ToDto(TDomain obj);
	}
}