CREATE TABLE FICHA_CAMPO
(
  id                      INTEGER not NULL AUTO_INCREMENT,
  muestra                 VARCHAR(255),
  origen_roca             VARCHAR(255),
  unidad_geologica        VARCHAR(255),
  contacto_geologico      VARCHAR(255),
  ubicacion_id            INTEGER,
  estructura_geologica_id INTEGER,
  catalogacion_id         INTEGER,
  PRIMARY KEY (id)
);

CREATE TABLE UBICACION
(
  id        INTEGER not NULL AUTO_INCREMENT,
  fecha     VARCHAR(255),
  escala    VARCHAR(255),
  provincia VARCHAR(255),
  canton    VARCHAR(255),
  sector    VARCHAR(55),
  foto      BLOB,
  PRIMARY KEY (id)
);


# Estructura geologica
CREATE TABLE ESTRUCTURA_GEOLOGICA
(
  id                        INTEGER not NULL AUTO_INCREMENT,
  categoria                 VARCHAR(255),
  subcategoria              VARCHAR(255),
  descripcion               TEXT,
  institucion_generadora    VARCHAR(255),
  estructura_geologica_type VARCHAR(255),

  # SUBTIPOS
  # Falla
  # Campo comun para:estructura_lineal, diaclasa y falla
  rumbo                     FLOAT(4),
  #   TODO check this buzamiento
  # Campo comun para: estructura_lineal, Estructura_plana, falla, pliegue
  buzamiento                FLOAT(2),
  azimut                    FLOAT,
  clase_falla               VARCHAR(3),
  estado                    boolean,
  #   TRUE para activa, False para Inactiva
  certeza                   VARCHAR(2),
  escarpe                   VARCHAR(255),
  #   estructura_lineal
  clase_estr_lineal         VARCHAR(2),
  lineacion                 VARCHAR(2),
  #   Estructura_plana
  #   Campo comun para estructura_plana y diaclasa
  buzamiento_intensidad     varchar(1),
  clivaje                   VARCHAR(2),
  estratificacion           VARCHAR(2),
  fotogeologia              VARCHAR(2),
  zona_de_cizalla           VARCHAR(2),
  #  Dique
  clase_dique               VARCHAR(2),
  textura_de_roca           BOOLEAN,
  #   True para equigranular false para porifidica
  # Foliacion
  rocas_metaforicas         VARCHAR(2),
  rocas_igneas              VARCHAR(2),
  #   diaclasa
  direccion                 FLOAT,
  asociacion                BOOLEAN,
  #   True para sistema paralelas y False para diaclasas que se cortan
  formacion                 VARCHAR(1),
  diaclasa_clase            VARCHAR(2),
  # Pliegue
  tipo                      VARCHAR(2),
  altura                    float,
  separacion                float,
  posicion                  varchar(1),
  angulo_entre_flancos      varchar(1),
  perfil                    varchar(1),
  sistema                   VARCHAR(1),


  PRIMARY KEY (id)

);
#   CONSTRAINTS
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
 no - Normal
 in - Inversa
 dba - De Bajo ángulo
 dca - De Cabalgamiento
 tr - Transcurrente
 trd - Transcurrente dextral
 trs - Transcurrente sinextral
 ddb - De Desplazamiento de buzamiento
 ddo - De Desplazamiento oblicuo
 ddp - De Despegue
 lis - Lístrica
 des - Desconocida
 */
  add constraint ck_falla_clase check (clase_falla in
                                       ('no', 'in', 'dba', 'dca', 'tr', 'trd', 'trs', 'ddb', 'ddo', 'ddp', 'lis',
                                        'des'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    in - Inferida
    ob - Observada
    fg -Por fotografía
     */
  add constraint ck_falla_certeza check (certeza in
                                         ('in', 'ob', 'fg'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    is - Intersección
    cn - Crenulación
    eg - Elongación
    em - Elongación mineral
    bd - Boudinage
    cl - Columnar
    et - Estría
    sm - Sedimentaria
    */
  add constraint ck_estr_lineal_clase check (clase_estr_lineal in
                                             ('is', 'cn', 'eg', 'em', 'bd', 'cl', 'et', 'sm'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  ic - Inclinado
  ho - Horizontal
  vt - Vertical
   */
  add constraint ck_estr_lineal_lineacion check (lineacion in
                                                 ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     s - Suave
     m - Mediano
     f - Fuerte
      */
  add constraint ck_buzamiento_intensidad check (buzamiento_intensidad in
                                                 ('s', 'm', 'f'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  ce - Clivaje espaciado
  cp - Clivaje penetrativo
  cf - Clivaje de fractura
  ci - Clivaje pizarroso
  cc - Clivaje crenulado
  cs - Clivaje de solución
  */
  add constraint ck_estr_plana_clivaje check (clivaje in
                                              ('ce', 'cp', 'cf', 'ci', 'cc', 'cs'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
   cl - Capa inclinada
   ch - Capa horizontal
   cv - Capa vertical
   ci - Capa invertida
   */
  add constraint ck_estr_plana_estratificacion check (estratificacion in
                                                      ('cl', 'ch', 'cv', 'ci'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    ii - Inclinación Indeterminada
    sh - Superficie Horizontal
    sv - Superficie Vertical
    in - Inclinación indeterminada invertida
       */
  add constraint ck_estr_plana_fotogeologia check (fotogeologia in
                                                   ('ii', 'sh', 'sv', 'in'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    zm - Zonas miloniticas
    zb - Zona de brechas
    in - Inclinada
    cz - Cizalla
    */
  add constraint ck_estr_plana_zona_de_cizalla check (zona_de_cizalla in
                                                      ('zm', 'zb', 'in', 'cz'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     ic - Inclinado
     ho - Horizontal
     vt - Vertical
      */
  add constraint ck_dique_clase_dique check (clase_dique in
                                             ('ic', 'ho', 'vt'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
   ic - Inclinado
   ho - Horizontal
   vt - Vertical
    */
  add constraint ck_foliacion_rocas_metaforicas check (rocas_metaforicas in
                                                       ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     ic - Inclinado
     ho - Horizontal
     vt - Vertical
      */
  add constraint ck_foliacion_rocas_igneas check (rocas_igneas in
                                                  ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  d - Deshidratación
  e - Enfriamiento
  r - Recristalización

      */
  add constraint ck_diaclasa_formacion check (formacion in
                                              ('d', 'e', 'r'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
       ic - Inclinado
       ho - Horizontal
       vt - Vertical
        */
  add constraint ck_diaclasa_clase check (diaclasa_clase in
                                          ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  af - Antiforme
  sf - Sinforme
  nt - Neutro
  ac - Anticlinal
  sc - Sinclinal
  mc - Monoclinal

       */
  add constraint ck_pliegue_tipo check (tipo in
                                        ('af', 'sf', 'nt', 'ac', 'sc', 'mc'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    p - Parado
    i - Inclinado
    r - Recumbente
    s - Sobreplegado
           */
  add constraint ck_pliegue_posicion check (posicion in
                                            ('p', 'i', 'r', 's'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  l - Leve
  a - Abierto
  c - Cerrado
  p - Apretado
  i - Isoclinal
             */
  add constraint ck_pliegue_angulo_entre_flancos check (angulo_entre_flancos in
                                                        ('l', 'a', 'c', 'p', 'i'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
p - Paralelo (Concéntrico)
s - Similar
a - En acordeón (Chevron)
   */
  add constraint ck_pliegue_perfil check (perfil in
                                          ('p', 's', 'a'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    s - Simétricos
    a - Asimétricos
    p - Parásitos (Satélites)
    u - Armonicos
    d - Desarmónicos
    c - Conjugados
    l - Policlinales
           */
  add constraint ck_pliegue_sistema check (sistema in
                                           ('s', 'a', 'p', 'u', 'd', 'c', 'l'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
 no - Normal
 in - Inversa
 dba - De Bajo ángulo
 dca - De Cabalgamiento
 tr - Transcurrente
 trd - Transcurrente dextral
 trs - Transcurrente sinextral
 ddb - De Desplazamiento de buzamiento
 ddo - De Desplazamiento oblicuo
 ddp - De Despegue
 lis - Lístrica
 des - Desconocida
 */
  add constraint ck_falla_clase check (clase_falla in
                                       ('no', 'in', 'dba', 'dca', 'tr', 'trd', 'trs', 'ddb', 'ddo', 'ddp', 'lis',
                                        'des'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    in - Inferida
    ob - Observada
    fg -Por fotografía
     */
  add constraint ck_falla_certeza check (certeza in
                                         ('in', 'ob', 'fg'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    is - Intersección
    cn - Crenulación
    eg - Elongación
    em - Elongación mineral
    bd - Boudinage
    cl - Columnar
    et - Estría
    sm - Sedimentaria
    */
  add constraint ck_estr_lineal_clase check (clase_estr_lineal in
                                             ('is', 'cn', 'eg', 'em', 'bd', 'cl', 'et', 'sm'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  ic - Inclinado
  ho - Horizontal
  vt - Vertical
   */
  add constraint ck_estr_lineal_lineacion check (lineacion in
                                                 ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     s - Suave
     m - Mediano
     f - Fuerte
      */
  add constraint ck_buzamiento_intensidad check (buzamiento_intensidad in
                                                 ('s', 'm', 'f'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  ce - Clivaje espaciado
  cp - Clivaje penetrativo
  cf - Clivaje de fractura
  ci - Clivaje pizarroso
  cc - Clivaje crenulado
  cs - Clivaje de solución
  */
  add constraint ck_estr_plana_clivaje check (clivaje in
                                              ('ce', 'cp', 'cf', 'ci', 'cc', 'cs'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
   cl - Capa inclinada
   ch - Capa horizontal
   cv - Capa vertical
   ci - Capa invertida
   */
  add constraint ck_estr_plana_estratificacion check (estratificacion in
                                                      ('cl', 'ch', 'cv', 'ci'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    ii - Inclinación Indeterminada
    sh - Superficie Horizontal
    sv - Superficie Vertical
    in - Inclinación indeterminada invertida
       */
  add constraint ck_estr_plana_fotogeologia check (fotogeologia in
                                                   ('ii', 'sh', 'sv', 'in'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    zm - Zonas miloniticas
    zb - Zona de brechas
    in - Inclinada
    cz - Cizalla
    */
  add constraint ck_estr_plana_zona_de_cizalla check (zona_de_cizalla in
                                                      ('zm', 'zb', 'in', 'cz'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     ic - Inclinado
     ho - Horizontal
     vt - Vertical
      */
  add constraint ck_dique_clase_dique check (clase_dique in
                                             ('ic', 'ho', 'vt'));

ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
   ic - Inclinado
   ho - Horizontal
   vt - Vertical
    */
  add constraint ck_foliacion_rocas_metaforicas check (rocas_metaforicas in
                                                       ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
     ic - Inclinado
     ho - Horizontal
     vt - Vertical
      */
  add constraint ck_foliacion_rocas_igneas check (rocas_igneas in
                                                  ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  d - Deshidratación
  e - Enfriamiento
  r - Recristalización

      */
  add constraint ck_diaclasa_formacion check (formacion in
                                              ('d', 'e', 'r'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
       ic - Inclinado
       ho - Horizontal
       vt - Vertical
        */
  add constraint ck_diaclasa_clase check (diaclasa_clase in
                                          ('ic', 'ho', 'vt'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  af - Antiforme
  sf - Sinforme
  nt - Neutro
  ac - Anticlinal
  sc - Sinclinal
  mc - Monoclinal

       */
  add constraint ck_pliegue_tipo check (tipo in
                                        ('af', 'sf', 'nt', 'ac', 'sc', 'mc'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    p - Parado
    i - Inclinado
    r - Recumbente
    s - Sobreplegado
           */
  add constraint ck_pliegue_posicion check (posicion in
                                            ('p', 'i', 'r', 's'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
  l - Leve
  a - Abierto
  c - Cerrado
  p - Apretado
  i - Isoclinal
             */
  add constraint ck_pliegue_angulo_entre_flancos check (angulo_entre_flancos in
                                                        ('l', 'a', 'c', 'p', 'i'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
p - Paralelo (Concéntrico)
s - Similar
a - En acordeón (Chevron)
   */
  add constraint ck_pliegue_perfil check (perfil in
                                          ('p', 's', 'a'));
ALTER TABLE ESTRUCTURA_GEOLOGICA
  /*
    s - Simétricos
    a - Asimétricos
    p - Parásitos (Satélites)
    u - Armonicos
    d - Desarmónicos
    c - Conjugados
    l - Policlinales
           */
  add constraint ck_pliegue_sistema check (sistema in
                                           ('s', 'a', 'p', 'u', 'd', 'c', 'l'));
# Catalogacion
CREATE TABLE CATALOGACION
(
  id                     INTEGER not NULL AUTO_INCREMENT,
  categoria              VARCHAR(255),
  subcategoria           VARCHAR(255),
  descripcion            TEXT,
  institucion_generadora VARCHAR(255),
  catalogacion_type      VARCHAR(255),

  # SUBTIPOS
  factores               VARCHAR(55),
  procesos               VARCHAR(55),
  clases                 VARCHAR(55),
  PRIMARY KEY (id)
);


##################


# Ficha de campo

# Tablas de catalogacion

CREATE TABLE alteracionHidrotermal
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  factores             VARCHAR(55),
  procesos             VARCHAR(55),
  clases               VARCHAR(55)
);

CREATE TABLE sitioFosilifero
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  localizacion         VARCHAR(55),
  nombre               VARCHAR(55),
  densidad             FLOAT,
  era                  VARCHAR(55),
  nomenclaturaEra      VARCHAR(55),
  periodo              VARCHAR(55),
  nomencalturaPeriodo  VARCHAR(55),
  epoca                VARCHAR(55),
  nomenclaturaEpoca    VARCHAR(55),
  piso                 VARCHAR(55),
  nomenclaturaPiso     VARCHAR(55)
);


CREATE TABLE muestra
(
  id                         serial PRIMARY KEY,
  categoria                  VARCHAR(255),
  subcategoria               VARCHAR(255),
  descripcion                TEXT,
  institucionGenerdora       VARCHAR(255),
  naturaleza                 VARCHAR(55),
  tipo                       VARCHAR(55),
  consistenciaMaterial       VARCHAR(55),
  codigo                     FLOAT,
  sitio                      VARCHAR(55),
  tipoAnalisis               VARCHAR(55),
  metodoAnalisis             VARCHAR(55),
  nomenclaturaMetodoAnalisis VARCHAR(55),
  cantidadMuestra            FLOAT,
  observacionies             VARCHAR(255)
);


CREATE TABLE fosil
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  reino                VARCHAR(55),
  clase                VARCHAR(55),
  flora                VARCHAR(55),
  fauna                VARCHAR(55),
  tamano               FLOAT,
  era                  VARCHAR(55),
  nomenclaturaEra      VARCHAR(55),
  periodo              VARCHAR(55),
  nomencalturaPeriodo  VARCHAR(55),
  epoca                VARCHAR(55),
  nomenclaturaEpoca    VARCHAR(55),
  piso                 VARCHAR(55),
  nomenclaturaPiso     VARCHAR(55)
);


CREATE TABLE afloramiento
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  diemension           FLOAT,
  origen               VARCHAR(55),
  tipoRoca             VARCHAR(55),
  sitio                VARCHAR(55)
);

CREATE TABLE contactoGeologico
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  limite               VARCHAR(55),
  tipo                 VARCHAR(55),
  certeza              VARCHAR(55)
);

CREATE TABLE roca
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  origen               VARCHAR(55),
  tipo                 VARCHAR(55),
  estructura           VARCHAR(55)
);

CREATE TABLE depositoSuperficial
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  clase                VARCHAR(55)
);

CREATE TABLE dominioLitotectonico
(
  id                   serial PRIMARY KEY,
  categoria            VARCHAR(255),
  subcategoria         VARCHAR(255),
  descripcion          TEXT,
  institucionGenerdora VARCHAR(255),
  region               VARCHAR(55)
);