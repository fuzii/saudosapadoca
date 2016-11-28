<html>
<body>
    <form action="addAccount">
      Nome: <input type="text" name="name" /><br />
      E-mail: <input type="text" name="email" /><br />
      <input type="submit" value="addAccount" />
    </form>
    <br/>
    <br/>
     <form action="addAddress">
		accountId: <input type="text" name="accountId"/><br />
		establishmentId: <input type="text" name="establishmentId"/><br />
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
      <input type="submit" value="addAddress" />
    </form>
    <br/>
    <br/>
     <form action="getEstablishmentByLocation">
		addressId: <input type="text" name="id"/><br />
      <input type="submit" value="getEstablishmentByLocation" />
    </form>
    <br/>
    <br/>
     <form action="addEstablishment">
		name: <input type="text" name="name"/><br />
		alias: <input type="text" name="alias"/><br />
		registerNumber: <input type="text" name="registerNumber"/><br />
      <input type="submit" value="addEstablishment"/>
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
