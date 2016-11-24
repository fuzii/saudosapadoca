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
		zipCode: <input type="text" name="zipCode"/><br />
		street: <input type="text" name="street"/><br />
		city: <input type="text" name="city"/><br />
		state: <input type="text" name="state"/><br />
		number: <input type="text" name="number"/><br />
		premise: <input type="text" name="premise"/><br />
		country: <input type="text" name="country"/><br />
		latitude: <input type="text" name="latitude"/><br />
		longitude: <input type="text" name="longitude"/><br />
      <input type="submit" value="addAddress" />
    </form>
    <br/>
    <br/>
     <form action="getAccount">
		param: <input type="text" name="param"/><br />
		value: <input type="text" name="value"/><br />
      <input type="submit" value="getAccount" />
    </form>
    
</body>
</html>
