package ers.dao;

import java.util.List;

import ers.beans.Forms;

public interface FormsDao {
	List<Forms> getAllForms();
	Forms getFormById(int form_id);
	Forms createForm(Forms f);
	Forms updateForm(Forms updateForm);
	long deleteForm(Forms... deleteForm);

}
