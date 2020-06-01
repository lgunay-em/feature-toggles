import { AppPage } from './app.po';
import { browser, logging } from 'protractor';

describe('workspace-project App', () => {
  let page: AppPage;

  beforeEach(() => {
    page = new AppPage();
  });

  it('should display page title correctly', () => {
    page.navigateTo();
    expect(page.getTitleText()).toEqual('Feature Toggles');
  });

  it('should display new feature button correctly', () => {
    page.navigateTo();
    expect(page.getNewButtonText()).toEqual('New Feature Toggle');
  });

  it('should display features table correctly', () => {
    page.navigateTo();
    expect(page.getFeaturesTable().isPresent()).toEqual(true);
  });

  afterEach(async () => {
    // Assert that there are no errors emitted from the browser
    const logs = await browser.manage().logs().get(logging.Type.BROWSER);
    expect(logs).not.toContain(jasmine.objectContaining({
      level: logging.Level.SEVERE,
    } as logging.Entry));
  });
});
