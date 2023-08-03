# prueba_vortex

Registrar los vehículos que se tienen disponibles para realizar los pedidos:

Método: POST
Ruta: /api/vehiculos
Funcionalidad: Permite registrar un nuevo vehículo con los detalles proporcionados en el cuerpo de la solicitud (JSON).
Obtener todos los vehículos disponibles:

Método: GET
Ruta: /api/vehiculos
Funcionalidad: Obtiene una lista de todos los vehículos disponibles registrados en el sistema.
Registrar los conductores que están contratados por la empresa:

Método: POST
Ruta: /api/conductores
Funcionalidad: Permite registrar un nuevo conductor con los detalles proporcionados en el cuerpo de la solicitud (JSON).
Obtener todos los conductores contratados:

Método: GET
Ruta: /api/conductores
Funcionalidad: Obtiene una lista de todos los conductores contratados registrados en el sistema.
Asociar un conductor a uno o varios vehículos:

Método: POST
Ruta: /api/conductores/{conductorId}/asignar-vehiculos
Funcionalidad: Asocia el conductor con el ID especificado en la ruta a los vehículos con los IDs proporcionados en el cuerpo de la solicitud (JSON). Solo se cargarán los vehículos que NO tienen un conductor asignado.
Desasociar a un conductor de un vehículo:

Método: POST
Ruta: /api/conductores/{conductorId}/desasociar-vehiculos
Funcionalidad: Desasocia el conductor con el ID especificado en la ruta de los vehículos con los IDs proporcionados en el cuerpo de la solicitud (JSON). Solo se cargarán los vehículos que ya han sido asignados previamente al conductor.
Obtener un conductor por ID:

Método: GET
Ruta: /api/conductores/{conductorId}
Funcionalidad: Obtiene un conductor específico por su ID.
Obtener un vehículo por ID:

Método: GET
Ruta: /api/vehiculos/{vehiculoId}
Funcionalidad: Obtiene un vehículo específico por su ID.
