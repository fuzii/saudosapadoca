<html>
<body>
	<form action="addAccount">
		name: <input type="text" name="name" /><br />
		email: <input type="text" name="email" /><br />
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
     <form action="getEstablishmentByLocation">
		addressId: <input type="text" name="id"/><br />
      <input type="submit" value="getEstablishmentByLocation" />
    </form>
    <br/>
    <br/>
     <form action="getAccounts">
     <input type="submit" value="getAccounts"/>
    </form>    
    <br/>
     <form action="getEstablishments">
     <input type="submit" value="getEstablishments"/>
    </form>    
</body>
</html>
