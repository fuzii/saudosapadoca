<%@page import="util.Util"%>
<%@page import="model.PriceList"%>
<%@page import="model.Establishment"%>

<html>
<body>

	<b>Session Access</b><br />
	UserId: <%= session.getAttribute("user_id") %><br />
	UserType: <%= session.getAttribute("user_type") %><br />
	EstablishmentId: <%= session.getAttribute("establishment_id") %><br />
	AccountId: <%= session.getAttribute("account_id") %><br />
	<br />
	<br />
	<br />
	<form action="addAccount">
		name: <input type="text" name="name" /><br /> email: <input
			type="text" name="email" /><br /> password: <input type="password"
			name="password" /><br /> phone: <input type="text" name="phone" /><br />
		<input type="submit" value="Cadastro Conta" />
	</form>
	<br />
	<br />
	<form action="addAddress">
		account_id: <input type="text" name="account_id" /><br /> zipCode: <input
			type="text" name="zipCode" /><br /> street: <input type="text"
			name="street" /><br /> city: <input type="text" name="city" /><br />
		state: <input type="text" name="state" /><br /> number: <input
			type="text" name="number" /><br /> premise: <input type="text"
			name="premise" /><br /> country: <input type="text" name="country" /><br />
		latitude: <input type="text" name="latitude" /><br /> longitude: <input
			type="text" name="longitude" /><br /> <input type="submit"
			value="Cadastro Endereço da Conta" />
	</form>
	<br />
	<br />
	<form action="addLead">
		name: <input type="text" name="name" /><br /> email: <input
			type="text" name="email" /><br /> zipCode: <input type="text"
			name="zipCode" /><br /> street: <input type="text" name="street" /><br />
		city: <input type="text" name="city" /><br /> state: <input
			type="text" name="state" /><br /> number: <input type="text"
			name="number" /><br /> country: <input type="text" name="country" /><br />
		latitude: <input type="text" name="latitude" /><br /> longitude: <input
			type="text" name="longitude" /><br /> <input type="submit"
			value="Cadastro Lead" />
	</form>
	<br />
	<br />
	<form action="addEstablishment">
		name: <input type="text" name="name" /><br /> alias: <input
			type="text" name="alias" /><br /> registerNumber: <input type="text"
			name="register_number" /><br /> email: <input type="text"
			name="email" /><br /> phone: <input type="text" name="phone" /><br />
		radius: <input type="text" name="radius" /><br /> responsibleName: <input
			type="text" name="responsible_name" /><br /> responsibleEmail: <input
			type="text" name="responsible_email" /><br /> responsiblePhone: <input
			type="text" name="responsible_phone" /><br /> password: <input
			type="password" name="password" /><br /> zipCode: <input
			type="text" name="zipCode" /><br /> street: <input type="text"
			name="street" /><br /> city: <input type="text" name="city" /><br />
		state: <input type="text" name="state" /><br /> number: <input
			type="text" name="number" /><br /> premise: <input type="text"
			name="premise" /><br /> country: <input type="text" name="country" /><br />
		latitude: <input type="text" name="latitude" /><br /> longitude: <input
			type="text" name="longitude" /><br /> <input type="submit"
			value="Cadastro Estabelecimento" />
	</form>
	<br />
	<br />
	<form action="addSchedule">
		Estabelecimento Id:<input type="text" name="establishment_id" /><br />
		seg-sex<br /> inicio: <input type="text" name="week_start_time" />
		fim: <input type="text" name="week_end_time" /><br /> sábado<br />
		inicio: <input type="text" name="saturday_start_time" /> fim: <input
			type="text" name="saturday_end_time" /><br /> domingo<br /> inicio:
		<input type="text" name="sunday_start_time" /> fim: <input type="text"
			name="sunday_end_time" /><br /> <input type="submit"
			value="Schedule" />
	</form>
	<br />
	<br />
	<form action="addPriceList">
		Estabelecimento Id:<input type="text" name="establishment_id" /><br />
		Product Id:<input type="text" name="product_id" /><br /> Price:<input
			type="text" name="price" /><br /> Unit:<input type="text" name="unit" /><br />
		<input type="submit" value="Price List" />
	</form>

	<br />
	<br />
	<form action="addProduct">
		name: <input type="text" name="name" /><br /> description: <input
			type="text" name="description" /><br /> <input type="submit"
			value="Cadastro Produto" />
	</form>
	<br />
	<br />
	<form action="addOrder">
		status: <input type="text" name="status" /><br /> 
		monday<br /> 
		time: <input type="text" name="monday_time" /><br /> 
		amount: <input type="text" name="monday_amount" /><br /> 
		tuesday<br /> 
		time: <input type="text" name="tuesday_time" /><br /> 
		amount: <input type="text" name="tuesday_amount" /><br /> 
		wednesday<br /> 
		time: <input type="text" name="wednesday_time" /><br /> 
		amount: <input type="text" name="wednesday_amount" /><br /> 
		thursday<br /> 
		time: <input type="text" name="thursday_time" /><br /> 
		amount: <input type="text" name="thursday_amount" /><br /> 
		friday<br /> 
		time: <input type="text" name="friday_time" /><br /> 
		amount: <input type="text" name="friday_amount" /><br /> 
		saturday<br /> 
		time: <input type="text" name="saturday_time" /><br /> 
		amount: <input type="text" name="saturday_amount" /><br /> 
		sunday<br /> 
		time: <input type="text" name="sunday_time" /><br /> 
		amount: <input type="text" name="sunday_amount" /><br /> 		
		<input type="submit" value="Cadastro Ordem" />
	</form>
	<br />
	<br />
	<form action="getFoursquare">
		latitude: <input type="text" name="latitude" /><br /> longitude: <input
			type="text" name="longitude" /><br /> <input type="submit"
			value="Foursquare - lat lng" />
	</form>
	<br />
	<br />
	<form action="getFoursquare">
		near: <input type="text" name="near" /><br /> <input type="submit"
			value="Foursquare - near" />
	</form>
	<br />
	<br />

	<form action="getEstablishments">
		latitude: <input type="text" name="latitude" /><br /> longitude: <input
			type="text" name="longitude" /><br /> <input type="submit"
			value="Base de dados" />
	</form>
	<br />
	<br />
	<form action="login">
		login: <input type="text" name="login" /><br /> password: <input
			type="password" name="password" /><br /> <input type="submit"
			value="login" />
	</form>
	<br />
</body>
</html>
