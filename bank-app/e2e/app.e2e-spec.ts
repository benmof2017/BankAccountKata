import { BankAppPage } from './app.po';

describe('bank-app App', () => {
  let page: BankAppPage;

  beforeEach(() => {
    page = new BankAppPage();
  });

  it('should display welcome message', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('Welcome to app!!');
  });
});
