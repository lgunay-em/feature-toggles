import { browser, by, element } from 'protractor';

export class AppPage {
  navigateTo() {
    return browser.get(browser.baseUrl) as Promise<any>;
  }

  getTitleText() {
    return element(by.css('app-root .mat-toolbar .mat-toolbar-row span')).getText() as Promise<string>;
  }

  getNewButtonText() {
    return element(by.css('app-root app-features .mat-header-row .mat-header-cell button')).getText() as Promise<string>;
  }

  getFeaturesTable() {
    return element(by.css('app-root app-features table'));
  }
}
