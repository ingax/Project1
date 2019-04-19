window.onload = () => {
	getAllForms();
	document.getElementById("createForm").addEventListener("click", createForm);
}

const getAllForms = () => {
	const xhr = new XMLHttpRequest();
	xhr.onreadystatechange = () => {
		if (xhr.status === 200 && xhr.readyState === 4) {
			const json = xhr.responseText;
			console.log(json);
			makeTable(JSON.parse(json));
		}
	};
	
	xhr.open("GET", "http://localhost:8088/ERS/api/forms");
	xhr.send();
}

const makeTable = (listOfRequest) => {
	for(let request of listOfRequest){
		const formId = document.createElement("td");
		const amount = document.createElement("td");
		const reason = document.createElement("td");
		const employeeId = document.createElement("td");
		const decision = document.createElement("td");
		
		formId.textContent = request.form_id;
		amount.textContent = request.amount;
		reason.textContent = request.reason;
		employeeId.textContent = request.employee_id;
		decision.textContent = request.decisionMade;
		
		const row = document.createElement("tr");
		
		row.appendChild(formId);
		row.appendChild(amount);
		row.appendChild(reason);
		row.appendChild(employeeId);
		row.appendChild(decision);
		
		document.getElementById("pendingTable").appendChild(row);
	}
}

const createForm = () => {
	const xhr = new XMLHttpRequest();
	
	const data = parseForm();
	
	xhr.onreadystatechange = () => {
		console.log("in readystate...")
		if(xhr.readyStatus === 200 && xhr.readyStatus === 4){
			const json = xhr.responseText;
			console.log(json);
		}
	}
		xhr.open("POST", "http://localhost:8088/ERS/api/forms");
		
		xhr.send(JSON.stringify(data));
}

const parseForm = () => {
	const formId = document.getElementById("form_id").value;
	const amountVal = document.getElementById("amount").value;
	const reasonVal = document.getElementById("reason").value;
	const empId = document.getElementById("employee_id").value;
	 return {
		 form_id: formId,
		 amount: amountVal,
		 reason: reasonVal,
		 employee_id: empId
	 };
}
