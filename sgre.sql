USE [SGRE]
GO
/****** Object:  Table [dbo].[tb_anli]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_anli](
	[cl_anli_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_anli_usua_id] [int] NOT NULL,
	[cl_anli_clie_ruc] [varchar](11) NOT NULL,
	[cl_anli_fren_id] [int] NOT NULL,
	[cl_anli_sfre_id] [int] NOT NULL,
 CONSTRAINT [tb_anli_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_anli_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_clie]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_clie](
	[cl_clie_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_clie_ruc] [varchar](11) NULL,
	[cl_clie_razonsoc] [varchar](40) NULL,
	[cl_clie_direccion] [varchar](100) NULL,
	[cl_clie_codigo] [varchar](12) NULL,
 CONSTRAINT [tb_clie_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_clie_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_conf]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_conf](
	[cl_conf_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_conf_minidiasproy] [int] NULL,
 CONSTRAINT [tb_conf_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_conf_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_coor]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_coor](
	[cl_coor_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_coor_usua_id] [int] NOT NULL,
	[cl_coor_clie_ruc] [varchar](11) NOT NULL,
	[cl_coor_fren_id] [int] NOT NULL,
	[cl_coor_sfre_id] [int] NOT NULL,
 CONSTRAINT [tb_coor_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_coor_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_doad]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_doad](
	[cl_doad_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_doad_requ_id] [int] NOT NULL,
	[cl_doad_version] [varchar](20) NULL,
	[cl_doad_uri] [varchar](80) NULL,
	[cl_doad_tipo] [char](1) NULL,
 CONSTRAINT [tb_doad_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_doad_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_esad]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_esad](
	[cl_esad_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_esad_requ_id] [int] NOT NULL,
	[cl_esad_estadoreq] [varchar](20) NULL,
	[cl_esad_estado] [char](1) NULL,
	[cl_esad_usuacrea] [varchar](80) NULL,
	[cl_esad_fechacrea] [date] NULL,
	[cl_esad_usuamodi] [varchar](80) NULL,
	[cl_esad_fechamodi] [date] NULL,
 CONSTRAINT [tb_esad_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_esad_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_esfu]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_esfu](
	[cl_esfu_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_esfu_requ_id] [int] NOT NULL,
	[cl_esfu_version] [varchar](20) NULL,
	[cl_esfu_uri] [varchar](80) NULL,
 CONSTRAINT [tb_esfu_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_esfu_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_fren]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_fren](
	[cl_fren_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_fren_nombre] [varchar](40) NULL,
 CONSTRAINT [tb_fren_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_fren_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_obse]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_obse](
	[cl_obse_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_obse_requ_id] [int] NOT NULL,
	[cl_obse_observacion] [varchar](200) NULL,
	[cl_obse_estado] [varchar](200) NULL,
	[cl_obse_flagleido] [char](1) NULL,
	[cl_obse_estadoreq] [varchar](20) NULL,
	[cl_obse_usuacrea] [varchar](80) NULL,
	[cl_obse_fechacrea] [date] NULL,
	[cl_obse_usuamodi] [varchar](80) NULL,
	[cl_obse_fechamodi] [date] NULL,
 CONSTRAINT [tb_obse_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_obse_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_ortr]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_ortr](
	[cl_ortr_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_ortr_requ_id] [int] NOT NULL,
	[cl_ortr_nombre] [varchar](80) NULL,
 CONSTRAINT [tb_ortr_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_ortr_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_requ]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_requ](
	[cl_requ_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_requ_usua_id] [int] NOT NULL,
	[cl_requ_clie_ruc] [varchar](11) NOT NULL,
	[cl_requ_codigo] [varchar](40) NULL,
	[cl_requ_titulo] [varchar](40) NULL,
	[cl_requ_detalle] [varchar](1000) NULL,
	[cl_requ_fren_id] [int] NOT NULL,
	[cl_requ_sfre_id] [int] NOT NULL,
	[cl_requ_espfunuri] [varchar](100) NULL,
	[cl_requ_dfturi] [varchar](100) NULL,
	[cl_requ_espfunuricoo] [varchar](100) NULL,
	[cl_requ_tipo] [varchar](100) NULL,
	[cl_requ_fechainicio] [date] NULL,
	[cl_requ_fechafin] [date] NULL,
	[cl_requ_numeroest] [int] NULL,
	[cl_requ_unidadest] [varchar](12) NULL,
	[cl_requ_flagleido] [char](1) NULL,
	[cl_requ_estadoreq] [varchar](20) NULL,
	[cl_requ_estado] [char](1) NULL,
	[cl_requ_usuacrea] [varchar](80) NULL,
	[cl_requ_fechacrea] [date] NULL,
	[cl_requ_usuamodi] [varchar](80) NULL,
	[cl_requ_fechamodi] [date] NULL,
 CONSTRAINT [tb_requ_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_requ_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_sfre]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_sfre](
	[cl_sfre_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_sfre_fren_id] [int] NULL,
	[cl_sfre_nombre] [varchar](40) NULL,
 CONSTRAINT [tb_sfre_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_sfre_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tb_usua]    Script Date: 8/01/2021 11:39:20 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_usua](
	[cl_usua_id] [int] IDENTITY(1,1) NOT NULL,
	[cl_usua_usuario] [varchar](40) NULL,
	[cl_usua_clave] [varchar](40) NULL,
	[cl_usua_nombre] [varchar](80) NULL,
	[cl_usua_email] [varchar](80) NULL,
	[cl_usua_celular] [varchar](80) NULL,
	[cl_usua_fechanac] [date] NULL,
	[cl_usua_role_id] [int] NULL,
	[cl_usua_estado] [char](1) NULL,
	[cl_usua_usuacrea] [varchar](80) NULL,
	[cl_usua_fechacrea] [date] NULL,
	[cl_usua_usuamodi] [varchar](80) NULL,
	[cl_usua_fechamodi] [date] NULL,
 CONSTRAINT [tb_usua_pkey] PRIMARY KEY CLUSTERED 
(
	[cl_usua_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tb_anli] ON 

INSERT [dbo].[tb_anli] ([cl_anli_id], [cl_anli_usua_id], [cl_anli_clie_ruc], [cl_anli_fren_id], [cl_anli_sfre_id]) VALUES (1, 1, N'10234526369', 1, 2)
INSERT [dbo].[tb_anli] ([cl_anli_id], [cl_anli_usua_id], [cl_anli_clie_ruc], [cl_anli_fren_id], [cl_anli_sfre_id]) VALUES (8, 1, N'10234526369', 1, 4)
INSERT [dbo].[tb_anli] ([cl_anli_id], [cl_anli_usua_id], [cl_anli_clie_ruc], [cl_anli_fren_id], [cl_anli_sfre_id]) VALUES (1004, 1, N'10234526369', 2, 5)
SET IDENTITY_INSERT [dbo].[tb_anli] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_clie] ON 

INSERT [dbo].[tb_clie] ([cl_clie_id], [cl_clie_ruc], [cl_clie_razonsoc], [cl_clie_direccion], [cl_clie_codigo]) VALUES (1, N'10234526369', N'Tailoy', N'Surquillo', N'TL')
INSERT [dbo].[tb_clie] ([cl_clie_id], [cl_clie_ruc], [cl_clie_razonsoc], [cl_clie_direccion], [cl_clie_codigo]) VALUES (2, N'10523645263', N'Glencore', N'Surco', N'GL')
SET IDENTITY_INSERT [dbo].[tb_clie] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_conf] ON 

INSERT [dbo].[tb_conf] ([cl_conf_id], [cl_conf_minidiasproy]) VALUES (1, 40)
SET IDENTITY_INSERT [dbo].[tb_conf] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_coor] ON 

INSERT [dbo].[tb_coor] ([cl_coor_id], [cl_coor_usua_id], [cl_coor_clie_ruc], [cl_coor_fren_id], [cl_coor_sfre_id]) VALUES (1, 2, N'10234526369', 1, 1)
INSERT [dbo].[tb_coor] ([cl_coor_id], [cl_coor_usua_id], [cl_coor_clie_ruc], [cl_coor_fren_id], [cl_coor_sfre_id]) VALUES (3, 2, N'10234526369', 1, 2)
INSERT [dbo].[tb_coor] ([cl_coor_id], [cl_coor_usua_id], [cl_coor_clie_ruc], [cl_coor_fren_id], [cl_coor_sfre_id]) VALUES (5, 2, N'10234526369', 1, 3)
INSERT [dbo].[tb_coor] ([cl_coor_id], [cl_coor_usua_id], [cl_coor_clie_ruc], [cl_coor_fren_id], [cl_coor_sfre_id]) VALUES (6, 2, N'10234526369', 1, 4)
INSERT [dbo].[tb_coor] ([cl_coor_id], [cl_coor_usua_id], [cl_coor_clie_ruc], [cl_coor_fren_id], [cl_coor_sfre_id]) VALUES (10, 2, N'10523645263', 1, 3)
SET IDENTITY_INSERT [dbo].[tb_coor] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_doad] ON 

INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (5, 2, N'V1', N'Horas_Glencore.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (7, 3, N'V1', N'Estimacion_SER.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (8, 3, N'V1', N'Estimacion.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (10, 4, N'V1', N'Estimacion_SER.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (11, 4, N'V1', N'Estimacion.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (13, 1006, N'V1', N'Horas_Zentra.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (14, 1006, N'V1', N'jota.xlsx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (1013, 1007, N'V1', N'CV_JOEL-TORRES-FLORES_2020.docx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (1014, 1007, N'V1', N'Carrito_de_Compras.docx', N'A')
INSERT [dbo].[tb_doad] ([cl_doad_id], [cl_doad_requ_id], [cl_doad_version], [cl_doad_uri], [cl_doad_tipo]) VALUES (1028, 1008, N'V1', N'Firebase.pptx', N'C')
SET IDENTITY_INSERT [dbo].[tb_doad] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_esad] ON 

INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2, 2, N'Estimado', NULL, N'jtorres', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (3, 3, N'Enviado a Estimar', NULL, N'eflower', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (4, 3, N'Observado', NULL, N'jtorres', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (5, 3, N'Enviado a Estimar', NULL, N'eflower', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (6, 3, N'Estimado', NULL, N'jtorres', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (7, 3, N'Rechazado', NULL, N'eflower', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (8, 4, N'Guardado', NULL, N'eflower', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (9, 4, N'Enviado a Estimar', NULL, N'eflower', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (10, 4, N'Observado', NULL, N'jtorres', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (11, 5, N'Guardado', NULL, N'eflower', CAST(N'2020-10-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (12, 6, N'Guardado', NULL, N'eflower', CAST(N'2020-10-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (13, 7, N'Guardado', NULL, N'eflower', CAST(N'2020-10-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (1011, 1006, N'Guardado', NULL, N'eflower', CAST(N'2020-11-03' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2011, 1007, N'Guardado', NULL, N'eflower', CAST(N'2020-11-20' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2012, 1007, N'Enviado a Estimar', NULL, N'eflower', CAST(N'2020-11-20' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2013, 1007, N'Estimado', NULL, N'jtorres', CAST(N'2020-11-20' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2014, 1008, N'Enviado a Estimar', NULL, N'eflower', CAST(N'2020-11-21' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2015, 1008, N'Estimado', NULL, N'jtorres', CAST(N'2020-11-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_esad] ([cl_esad_id], [cl_esad_requ_id], [cl_esad_estadoreq], [cl_esad_estado], [cl_esad_usuacrea], [cl_esad_fechacrea], [cl_esad_usuamodi], [cl_esad_fechamodi]) VALUES (2016, 1008, N'Aprobado', NULL, N'eflower', CAST(N'2020-11-23' AS Date), NULL, NULL)
SET IDENTITY_INSERT [dbo].[tb_esad] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_fren] ON 

INSERT [dbo].[tb_fren] ([cl_fren_id], [cl_fren_nombre]) VALUES (1, N'SAP')
INSERT [dbo].[tb_fren] ([cl_fren_id], [cl_fren_nombre]) VALUES (2, N'DEV')
SET IDENTITY_INSERT [dbo].[tb_fren] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_obse] ON 

INSERT [dbo].[tb_obse] ([cl_obse_id], [cl_obse_requ_id], [cl_obse_observacion], [cl_obse_estado], [cl_obse_flagleido], [cl_obse_estadoreq], [cl_obse_usuacrea], [cl_obse_fechacrea], [cl_obse_usuamodi], [cl_obse_fechamodi]) VALUES (1, 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL)
INSERT [dbo].[tb_obse] ([cl_obse_id], [cl_obse_requ_id], [cl_obse_observacion], [cl_obse_estado], [cl_obse_flagleido], [cl_obse_estadoreq], [cl_obse_usuacrea], [cl_obse_fechacrea], [cl_obse_usuamodi], [cl_obse_fechamodi]) VALUES (2, 3, N'Se requiere documento funcional', NULL, N'A', N'Observado', N'jtorres', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_obse] ([cl_obse_id], [cl_obse_requ_id], [cl_obse_observacion], [cl_obse_estado], [cl_obse_flagleido], [cl_obse_estadoreq], [cl_obse_usuacrea], [cl_obse_fechacrea], [cl_obse_usuamodi], [cl_obse_fechamodi]) VALUES (3, 3, N'Falta flujo de compras', NULL, N'C', N'Rechazado', N'eflower', CAST(N'2020-08-13' AS Date), NULL, NULL)
INSERT [dbo].[tb_obse] ([cl_obse_id], [cl_obse_requ_id], [cl_obse_observacion], [cl_obse_estado], [cl_obse_flagleido], [cl_obse_estadoreq], [cl_obse_usuacrea], [cl_obse_fechacrea], [cl_obse_usuamodi], [cl_obse_fechamodi]) VALUES (4, 4, N'ESPECIFICAR FLUJO', NULL, N'A', N'Observado', N'jtorres', CAST(N'2020-08-13' AS Date), NULL, NULL)
SET IDENTITY_INSERT [dbo].[tb_obse] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_requ] ON 

INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (1, 1, N'10234526369', N'TL-SAPSD-20200812102923', N'Mejora WM-ZWM988', N'Mejora WM-ZWM988', 1, 2, N'Horas_Glencore.xlsx', NULL, NULL, NULL, CAST(N'2020-08-12' AS Date), CAST(N'2020-08-13' AS Date), 1, N'dias', N' ', N'Estimado', N'X', N'eflower', CAST(N'2020-08-12' AS Date), N'jtorres', CAST(N'2020-08-12' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (2, 1, N'10234526369', N'TL-SAPSD-20200812123322', N'Mejora ZWMP012', N'Mejora ZWMP012', 1, 2, N'Estimacion_SER.xlsx', NULL, NULL, NULL, CAST(N'2020-08-13' AS Date), CAST(N'2020-08-20' AS Date), 8, N'dias', N' ', N'Estimado', N'X', N'eflower', CAST(N'2020-08-12' AS Date), N'eflower', CAST(N'2020-08-13' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (3, 1, N'10234526369', N'TL-SAPSD-20200813172657', N'Mejora WM-ZLTe', N'Mejora WM-ZLTe', 1, 2, NULL, NULL, NULL, NULL, CAST(N'2020-08-13' AS Date), CAST(N'2020-08-28' AS Date), 15, N'dias', N' ', N'Rechazado', N'X', N'eflower', CAST(N'2020-08-13' AS Date), N'eflower', CAST(N'2020-08-13' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (4, 1, N'10234526369', N'TL-SAPSD-20200813183253', N'Mejora ZWMP014', N'Mejora ZWMP014', 1, 2, NULL, NULL, NULL, N'Incidencia', CAST(N'2020-08-17' AS Date), CAST(N'2020-09-01' AS Date), 12, N'dias', N' ', N'Observado', N'X', N'eflower', CAST(N'2020-08-13' AS Date), N'eflower', CAST(N'2020-08-18' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (5, 1, N'10234526369', N'TL-SAPSD-20201023093957', N'Mejora WM-ZWM977', N'safFdsF', 1, 2, N'Glencore_-_Migracion_ZDE.xlsx', NULL, NULL, N'', NULL, NULL, 0, N'', N' ', N'Guardado', N'X', N'eflower', CAST(N'2020-10-23' AS Date), N'eflower', CAST(N'2020-11-03' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (6, 1, N'10234526369', N'TL-SAPSD-20201023094159', N'Mejora WM-ZWM989', N'55+65565', 1, 2, N'Glencore_-_Migracion_ZDE.xlsx', NULL, NULL, N'', NULL, NULL, 0, N'', N' ', N'Guardado', N'X', N'eflower', CAST(N'2020-10-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (7, 1, N'10234526369', N'TL-SAPSD-20201023094223', N'Mejora WM-ZWM989', N'55+65565', 1, 2, N'Glencore_-_Migracion_ZDE.xlsx', NULL, NULL, N'', NULL, NULL, 0, N'', N' ', N'Guardado', N'X', N'eflower', CAST(N'2020-10-23' AS Date), NULL, NULL)
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (1006, 1, N'10234526369', N'TL-SAPSD-20201103094818', N'INCIDENCIA WM ZWMP011', N'Duplicidad de impresion al generar HU multiple.', 1, 2, N'Doc5.docx', NULL, NULL, N'', NULL, NULL, 0, N'', N' ', N'Guardado', N'X', N'eflower', CAST(N'2020-11-03' AS Date), N'eflower', CAST(N'2020-11-03' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (1007, 1, N'10234526369', N'TL-SAPSD-20201120090519', N'TEst01', N'452136', 1, 2, N'test.xlsx', NULL, NULL, N'', NULL, NULL, 4, N'hrs', N' ', N'Estimado', N'X', N'eflower', CAST(N'2020-11-20' AS Date), N'jtorres', CAST(N'2020-11-20' AS Date))
INSERT [dbo].[tb_requ] ([cl_requ_id], [cl_requ_usua_id], [cl_requ_clie_ruc], [cl_requ_codigo], [cl_requ_titulo], [cl_requ_detalle], [cl_requ_fren_id], [cl_requ_sfre_id], [cl_requ_espfunuri], [cl_requ_dfturi], [cl_requ_espfunuricoo], [cl_requ_tipo], [cl_requ_fechainicio], [cl_requ_fechafin], [cl_requ_numeroest], [cl_requ_unidadest], [cl_requ_flagleido], [cl_requ_estadoreq], [cl_requ_estado], [cl_requ_usuacrea], [cl_requ_fechacrea], [cl_requ_usuamodi], [cl_requ_fechamodi]) VALUES (1008, 1, N'10234526369', N'TL-SAPSD-20201121190723', N'Mejora LT12', N'Consulta de articulo por ean maestro', 1, 2, N'test.xlsx', N'Firebase.pptx', N'Diapos_para_Ajinomoto.pptx', N'', CAST(N'2020-11-23' AS Date), CAST(N'2020-11-23' AS Date), 4, N'hrs', N' ', N'Aprobado', N'X', N'eflower', CAST(N'2020-11-21' AS Date), N'jtorres', CAST(N'2020-11-23' AS Date))
SET IDENTITY_INSERT [dbo].[tb_requ] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_sfre] ON 

INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (1, 1, N'MM')
INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (2, 1, N'SD')
INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (3, 1, N'FI')
INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (4, 1, N'WM')
INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (5, 2, N'JAVA')
INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (6, 2, N'NET')
INSERT [dbo].[tb_sfre] ([cl_sfre_id], [cl_sfre_fren_id], [cl_sfre_nombre]) VALUES (7, 2, N'BI')
SET IDENTITY_INSERT [dbo].[tb_sfre] OFF
GO
SET IDENTITY_INSERT [dbo].[tb_usua] ON 

INSERT [dbo].[tb_usua] ([cl_usua_id], [cl_usua_usuario], [cl_usua_clave], [cl_usua_nombre], [cl_usua_email], [cl_usua_celular], [cl_usua_fechanac], [cl_usua_role_id], [cl_usua_estado], [cl_usua_usuacrea], [cl_usua_fechacrea], [cl_usua_usuamodi], [cl_usua_fechamodi]) VALUES (1, N'eflower', N'MTIzNDU2', N'Edgard Flower', N'jhulio180@gmail.com', N'950934560', CAST(N'1988-06-02' AS Date), 3, N'X', NULL, NULL, NULL, NULL)
INSERT [dbo].[tb_usua] ([cl_usua_id], [cl_usua_usuario], [cl_usua_clave], [cl_usua_nombre], [cl_usua_email], [cl_usua_celular], [cl_usua_fechanac], [cl_usua_role_id], [cl_usua_estado], [cl_usua_usuacrea], [cl_usua_fechacrea], [cl_usua_usuamodi], [cl_usua_fechamodi]) VALUES (2, N'jtorres', N'MTIzNDU2', N'Joel Torres', N'jhoeles17@gmail.com', N'950935623', CAST(N'1988-05-04' AS Date), 4, N'X', NULL, NULL, NULL, NULL)
SET IDENTITY_INSERT [dbo].[tb_usua] OFF
GO
