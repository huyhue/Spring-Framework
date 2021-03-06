USE [demoSpring]
GO
/****** Object:  Table [dbo].[cards]    Script Date: 25/04/2021 3:48:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cards](
	[card_id] [bigint] NOT NULL,
	[card_balance] [float] NOT NULL,
	[currency] [varchar](255) NOT NULL,
	[user_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[card_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 25/04/2021 3:48:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[role_id] [int] NOT NULL,
	[role] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[transactions]    Script Date: 25/04/2021 3:48:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[transactions](
	[transaction_id] [bigint] NOT NULL,
	[iban] [varchar](255) NOT NULL,
	[purpose] [varchar](255) NOT NULL,
	[sum] [float] NULL,
	[card_id] [bigint] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[transaction_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[user_role]    Script Date: 25/04/2021 3:48:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user_role](
	[user_id] [bigint] NOT NULL,
	[role_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC,
	[role_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[users]    Script Date: 25/04/2021 3:48:19 CH ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[user_id] [bigint] NOT NULL,
	[email] [varchar](255) NOT NULL,
	[password] [varchar](255) NOT NULL,
	[username] [varchar](15) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[user_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[cards] ([card_id], [card_balance], [currency], [user_id]) VALUES (3, 15, N'EURO', 1)
INSERT [dbo].[cards] ([card_id], [card_balance], [currency], [user_id]) VALUES (4, 109, N'DOLLAR', 1)
INSERT [dbo].[cards] ([card_id], [card_balance], [currency], [user_id]) VALUES (5, 122, N'DOLLAR', 2)
INSERT [dbo].[role] ([role_id], [role]) VALUES (1, N'ROLE_ADMIN')
INSERT [dbo].[role] ([role_id], [role]) VALUES (2, N'ROLE_USER')
INSERT [dbo].[transactions] ([transaction_id], [iban], [purpose], [sum], [card_id]) VALUES (6, N'huyhue', N'vay tien thang 4', 23, 4)
INSERT [dbo].[transactions] ([transaction_id], [iban], [purpose], [sum], [card_id]) VALUES (7, N'leminh', N' no tien thang 4', 23, 4)
INSERT [dbo].[user_role] ([user_id], [role_id]) VALUES (8, 2)
INSERT [dbo].[users] ([user_id], [email], [password], [username]) VALUES (1, N'tpgiahuy5@gmail.com', N'$2a$10$heILTInH15BUIsBo0dsh/uJX086rVEIFidwSFx9FB/hPYHo/LIsIK', N'admin')
INSERT [dbo].[users] ([user_id], [email], [password], [username]) VALUES (2, N'huytpgde140306@fpt.edu.vn', N'$2a$10$iJDTRZ/zvqiB3cwNU2eV1.zK/Maasxylgrz6rm1KDk1OTXORNG4BC', N'huyhue')
INSERT [dbo].[users] ([user_id], [email], [password], [username]) VALUES (8, N'tpgiahuy55@gmail.com', N'$2a$10$r6YbRIg6189E05MVwX0KKeRZrJKWeLXCDnbwieeC6anEUcid9G4VS', N'de140306')
ALTER TABLE [dbo].[cards]  WITH CHECK ADD  CONSTRAINT [FKcmanafgwbibfijy2o5isfk3d5] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[cards] CHECK CONSTRAINT [FKcmanafgwbibfijy2o5isfk3d5]
GO
ALTER TABLE [dbo].[transactions]  WITH CHECK ADD  CONSTRAINT [FKjxdscq0bxpy0pl465vvsqc89j] FOREIGN KEY([card_id])
REFERENCES [dbo].[cards] ([card_id])
GO
ALTER TABLE [dbo].[transactions] CHECK CONSTRAINT [FKjxdscq0bxpy0pl465vvsqc89j]
GO
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FKa68196081fvovjhkek5m97n3y] FOREIGN KEY([role_id])
REFERENCES [dbo].[role] ([role_id])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FKa68196081fvovjhkek5m97n3y]
GO
ALTER TABLE [dbo].[user_role]  WITH CHECK ADD  CONSTRAINT [FKj345gk1bovqvfame88rcx7yyx] FOREIGN KEY([user_id])
REFERENCES [dbo].[users] ([user_id])
GO
ALTER TABLE [dbo].[user_role] CHECK CONSTRAINT [FKj345gk1bovqvfame88rcx7yyx]
GO
