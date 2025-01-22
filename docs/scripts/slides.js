import { SfeirThemeInitializer } from '../web_modules/sfeir-school-theme/sfeir-school-theme.mjs';

// One method per module
function schoolSlides() {
  return [
    '00-school/00-presentation.md',
    '00-school/01-ajy.md',
    '00-school/02-sle.md',
    '00-school/03-wifi.md'
  ];
}

function introSlides() {
  return [
    '01-introduction/00-intro.md',
    '01-introduction/01-objectifs.md'
  ];
}

function coursSlides() {
  return [
    '02-cours/00-spring-native.md',
    '02-cours/02-avantages-inconvenients.md',
    '02-cours/03-cas-usages.md',
    '02-cours/04-fonctionnement.md',
    '02-cours/05-performances.md',
    '02-cours/06-configuration.md',
    '02-cours/07-deploiement.md',
  ];
}

function docSlides() {
  return [
    '03-docs/01-docs.md',
    '03-docs/02-sondage.md',
  ];
}

function formation() {
  return [
    //
    ...schoolSlides(), //
    ...introSlides(), //
    ...coursSlides(), //
    ...docSlides(), //
  ].map((slidePath) => {
    return { path: slidePath };
  });
}

SfeirThemeInitializer.init(formation);
