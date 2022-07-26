package visa.ssfworkshop14.app.service;

import visa.ssfworkshop14.app.model.Contact;

public interface ContactsRepo {
    public void save(final Contact ctc);

    public Contact findById(final String contactId);
}
