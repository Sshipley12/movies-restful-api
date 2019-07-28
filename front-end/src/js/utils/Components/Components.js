import Html from "../Html/Html";
import Api from "../Api/Api";

export default () => new Components();

class Components {
  getAppContext() {
    return Html().select("#app");
  }
  getWrapperDiv() {
    return Html()
      .create("div")
      .addClass("wrapper");
  }
  renderMainFooter() {
    const footer = Html()
      .create("footer")
      .addClass("footer");
    const footerCopy = Html()
      .create("small")
      .addClass("footer__text")
      .html("&copy; 2019");
    footer.addChild(footerCopy);
    return footer;
  }
  renderPageHome() {
    const app = this.getAppContext();
    const wrapper = this.getWrapperDiv();
    const footer = this.renderMainFooter();

    wrapper.addChild(footer);
    app.addChild(wrapper);
  }
  renderMainHeader() {
    const mainHeader = Html()
      .create("header")
      .addClass("main-header");
    const mainHeaderTitle = Html()
      .create("h1")
      .addClass("main-header__title");
  }
}
