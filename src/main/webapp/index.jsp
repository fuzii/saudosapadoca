<html>
<body>
	<form action="addAccount"> 
		name: <input type="text" name="name" /><br />
		email: <input type="text" name="email" /><br />
		password: <input type="password" name="password" /><br />
		phone: <input type="text" name="phone" /><br />
		zipCode: <input type="text" name="zipCode"/><br />
		street: <input type="text" name="street"/><br />
		city: <input type="text" name="city"/><br />
		state: <input type="text" name="state"/><br />
		number: <input type="text" name="number"/><br />
		premise: <input type="text" name="premise"/><br />
		country: <input type="text" name="country"/><br />
		latitude: <input type="text" name="latitude"/><br />
		longitude: <input type="text" name="longitude"/><br />
		<input type="submit" value="CadastroConta" />
	</form>
    <br/>
    <br/>
    <form action="addLead"> 
		name: <input type="text" name="name" /><br />
		email: <input type="text" name="email" /><br />
		zipCode: <input type="text" name="zipCode"/><br />
		street: <input type="text" name="street"/><br />
		city: <input type="text" name="city"/><br />
		state: <input type="text" name="state"/><br />
		number: <input type="text" name="number"/><br />
		country: <input type="text" name="country"/><br />
		latitude: <input type="text" name="latitude"/><br />
		longitude: <input type="text" name="longitude"/><br />
		<input type="submit" value="CadastroLead" />
	</form>
    <br/>
    <br/>
     <form action="addEstablishment">
		name: <input type="text" name="name"/><br />
		alias: <input type="text" name="alias"/><br />
		registerNumber: <input type="text" name="registerNumber"/><br />
		zipCode: <input type="text" name="zipCode"/><br />
		street: <input type="text" name="street"/><br />
		city: <input type="text" name="city"/><br />
		state: <input type="text" name="state"/><br />
		number: <input type="text" name="number"/><br />
		premise: <input type="text" name="premise"/><br />
		country: <input type="text" name="country"/><br />
		latitude: <input type="text" name="latitude"/><br />
		longitude: <input type="text" name="longitude"/><br />
		radius: <input type="text" name="radius"/><br />
      <input type="submit" value="CadastroPadaria"/>
    </form>	
    <br/>
    <br/>
     <form action="getFoursquareServlet">
		latitude: <input type="text" name="latitude"/><br />
      	longitude: <input type="text" name="longitude"/><br />
      <input type="submit" value="Foursquare" />
    </form>
    <br/>
    <br/>
	<form action="login"> 
		login: <input type="text" name="login" /><br />
		password: <input type="password" name="password" /><br />
		<input type="submit" value="login" />
	</form>
    <br/> 
</body>
</html>
